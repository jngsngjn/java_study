package dump;

public class StackOverFlowErrorExample {
    public static void main(String[] args) {
        try {
            recursiveCall();
        } catch (StackOverflowError error) {
            System.out.println("StackOverflowError catch");
        }
    }

    public static void recursiveCall() {
        recursiveCall();
    }
}