package thread;

import static java.lang.Thread.State.TIMED_WAITING;
import static util.ThreadUtil.sleep;

public class InterruptTest2 {
    public static void main(String[] args) {
        Thread worker = new Thread(new Worker());
        worker.start();

        System.out.println("main 스레드 2초 sleep..");
        sleep(2000);

        if (worker.getState() == TIMED_WAITING) {
            System.out.println("main 스레드 -> Worker 스레드 interrupt() 호출");
            worker.interrupt();
        }
    }

    static class Worker implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Worker 스레드 깨어남!");
                } catch (InterruptedException e) {
                    System.out.println("Worker 스레드 인터럽트 신호 받음!");
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Worker 스레드 종료");
        }
    }
}