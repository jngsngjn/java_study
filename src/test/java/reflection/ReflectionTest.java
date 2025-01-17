package reflection;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

class ReflectionTest {

    @Test
    void testCalculator_1() throws Exception {
        Class<?> calculatorClass = Class.forName("reflection.Calculator");

        Constructor<?> constructor = calculatorClass.getDeclaredConstructor();
        Calculator calculator = (Calculator) constructor.newInstance();

        Method addMethod = calculatorClass.getDeclaredMethod("add", int.class, int.class);
        addMethod.setAccessible(true); // private 생성자 접근 허용

        int a = 5, b = 3;
        int answer = a + b;
        int result = (int) addMethod.invoke(calculator, a, b);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    void testCalculator_2() throws Exception {
        int a = 10, b = 20;
        int answer = Math.max(a, b);

        Class<?> calculatorClass = Class.forName("reflection.Calculator");
        Method maxMethod = calculatorClass.getDeclaredMethod("max", int.class, int.class);
        int result = (int) maxMethod.invoke(null, a, b);

        assertThat(result).isEqualTo(answer);
    }

//    @Test
//    void student() throws Exception {
//        String name = "StudentA";
//        int score = 90;
//
//        Class<?> studentClass = Class.forName("reflection.Student");
//        Constructor<?> constructor = studentClass.getDeclaredConstructor(String.class, int.class);
//        Student studentA = (Student) constructor.newInstance(name, score);
//
//        assertThat(studentA).isEqualTo(new Student(name, score));
//    }

    @Test
    void testClassNotFoundException() {
        assertThatThrownBy(() -> Class.forName("reflection.students"))
                .isExactlyInstanceOf(ClassNotFoundException.class);
    }

    @Test
    void testNoSuchMethodException() throws Exception {
        Class<?> studentClass = Class.forName("reflection.Student");
        assertThatThrownBy(() -> studentClass.getDeclaredMethod("nonExistentMethod"))
                .isExactlyInstanceOf(NoSuchMethodException.class);

        assertThatThrownBy(() -> studentClass.getDeclaredConstructor())
                .isExactlyInstanceOf(NoSuchMethodException.class);
    }

    @Test
    void testIllegalAccessException() throws Exception {
        Class<?> studentClass = Class.forName("reflection.Student");
        Student student = (Student) studentClass.getDeclaredConstructor(String.class, int.class).newInstance("name", 90);
        Method method = studentClass.getDeclaredMethod("getDetails");

        assertThatThrownBy(() -> method.invoke(student))
                .isExactlyInstanceOf(IllegalAccessException.class);
    }

    @Test
    void testIllegalArgumentException() throws Exception {
        Class<?> studentClass = Class.forName("reflection.Student");
        Constructor<?> constructor = studentClass.getDeclaredConstructor(String.class, int.class);
        assertThatThrownBy(() -> constructor.newInstance())
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testInvocationTargetException() throws Exception {
        Class<?> studentClass = Class.forName("reflection.Student");
        Constructor<?> constructor = studentClass.getDeclaredConstructor(String.class, int.class);
        Student student = (Student) constructor.newInstance("StudentA", 90);

        Method method = studentClass.getDeclaredMethod("throwException");

        assertThatThrownBy(() -> method.invoke(student))
                .isInstanceOf(InvocationTargetException.class) // 래핑된 예외
                .hasCauseInstanceOf(RuntimeException.class) // 실제 예외
                .hasRootCauseMessage("This is a test exception");
    }
}