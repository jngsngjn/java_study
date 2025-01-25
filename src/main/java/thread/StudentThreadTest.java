package thread;

public class StudentThreadTest {

    public static StudentService studentService = StudentService.getInstance();

    public static void main(String[] args) {
        Runnable runnableA = () -> {
            studentService.setName("studentA");
            System.out.println("threadA.getName() = " + studentService.getName());
        };

        Runnable runnableB = () -> {
            studentService.setName("studentB");
            System.out.println("threadB.getName() = " + studentService.getName());
        };

        Thread threadA = new Thread(runnableA, "studentA-thread");
        Thread threadB = new Thread(runnableB, "studentB-thread");
        threadA.start();
        threadB.start();
    }
}