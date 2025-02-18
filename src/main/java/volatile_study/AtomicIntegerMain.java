package volatile_study;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerMain {

	private static AtomicInteger count = new AtomicInteger(0); // AtomicInteger 사용

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				count.incrementAndGet(); // 원자적 연산 보장
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				count.incrementAndGet();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("최종 count 값: " + count.get()); // 항상 2000 보장
	}
}