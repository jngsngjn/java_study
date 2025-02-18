package volatile_study;

public class NoVolatileMain {
	private static boolean flag = false;

	public static void main(String[] args) {
		Thread writer = new Thread(() -> {
			try {
				Thread.sleep(1000); // 1초 후 변경
				flag = true;
				System.out.println("Writer: flag 값을 true로 변경");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread reader = new Thread(() -> {
			while (!flag) { // flag가 true가 될 때까지 대기
				// 아무 작업 없이 루프만 돌고 있음 (가시성 문제 발생 가능)
			}
			System.out.println("Reader: flag가 true로 변경됨을 감지!");
		});

		writer.start();
		reader.start();
	}
}