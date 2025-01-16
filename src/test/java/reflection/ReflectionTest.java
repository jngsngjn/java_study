package reflection;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

public class ReflectionTest {

    @Test
    void testCalculator() throws Exception {
        Class<?> calculatorClass = Class.forName("reflection.Calculator");

        Constructor<?> constructor = calculatorClass.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Method addMethod = calculatorClass.getDeclaredMethod("add", int.class, int.class);
        addMethod.setAccessible(true); // private 생성자 접근 허용

        int a = 5, b = 3;
        int answer = a + b;
        int result = (int) addMethod.invoke(instance, a, b);

        assertThat(result).isEqualTo(answer);
    }
}