package thread;

public class StudentService {

    private static StudentService studentService;

    private StudentService() {
    }

    public static StudentService getInstance() {
        if (studentService == null) {
            studentService = new StudentService();
        }
        return studentService;
    }

    private final ThreadLocal<String> name = new ThreadLocal<>();

    public void setName(String name) {
        System.out.println(Thread.currentThread().getName() + "setName()" + name);
        this.name.set(name);
    }

    public String getName() {
        System.out.println(Thread.currentThread().getName() + "getName()");
        return name.get();
    }
}