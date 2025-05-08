package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapMain {

	public static Map<Integer, String> map = new ConcurrentHashMap<>();
	// public static Map<Integer, String> map = new HashMap<>();

	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		testWithPut();             // 비동기 메서드 테스트
		long endTime = System.currentTimeMillis();
		System.out.println("test 1 소요시간: " + (endTime - startTime) + "ms");

		map.clear();               // 맵 초기화
		System.out.println("===============================================");

		startTime = System.currentTimeMillis();
		testWithSynchronizedPut(); // 동기 메서드 테스트
		endTime = System.currentTimeMillis();
		System.out.println("test 2 소요시간: " + (endTime - startTime) + "ms");
	}

	public static void testWithPut() throws InterruptedException {
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(() -> {
				for (int j = 0; j < 10; j++) {
					put(j, Thread.currentThread().getName());
				}
			});
			threads.add(thread);
			thread.start();
		}
		for (Thread t : threads) t.join();

		System.out.println("[put] map size: " + map.size());
		System.out.println("[put] map content: " + map);
	}

	public static void testWithSynchronizedPut() throws InterruptedException {
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(() -> {
				for (int j = 0; j < 10; j++) {
					synchronizedPut(j, Thread.currentThread().getName());
				}
			});
			threads.add(thread);
			thread.start();
		}
		for (Thread t : threads) t.join();

		System.out.println("[synchronizedPut] map size: " + map.size());
		System.out.println("[synchronizedPut] map content: " + map);
	}

	public synchronized static void synchronizedPut(int key, String value) {
		map.put(key, value);
	}

	public static void put(int key, String value) {
		map.put(key, value);
	}
}