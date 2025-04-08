package thread;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("[WORKER] 자는 중...");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("[WORKER] 인터럽트 발생!");
                    System.out.println("[WORKER] 인터럽트 상태: " + Thread.currentThread().isInterrupted()); // false

                    Thread.currentThread().interrupt(); // 상태 복원
                    System.out.println("[WORKER] 복원 후 상태: " + Thread.currentThread().isInterrupted()); // true
                    break;
                }
            }
            System.out.println("[WORKER] 종료됨");
        });

        worker.start();

        // 1초 후 worker 스레드에 인터럽트 걸기
        Thread.sleep(1000);

        System.out.println("[MAIN] worker에 interrupt() 호출!");
        worker.interrupt();
    }
}