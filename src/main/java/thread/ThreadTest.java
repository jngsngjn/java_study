package thread;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(new Worker());
        worker.start();

        Thread.sleep(100);
        worker.interrupt();
    }

    static class Worker implements Runnable {
        @Override
        public void run() {
            try {
                test();
            } catch (InterruptedException e) {
                System.out.println("worker 인터럽트 신호 받음");
            }
            System.out.println("worker 종료");
        }

        synchronized void test() throws InterruptedException {
            wait();
        }
    }
}