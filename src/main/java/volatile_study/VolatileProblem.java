package volatile_study;

public class VolatileProblem {
	private static volatile int count = 0;

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				count++;  // 원자적 연산이 아님!
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				count++;
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

		System.out.println("최종 count 값: " + count); // 예상: 2000, 하지만 실제 값은 불확실
	}
}