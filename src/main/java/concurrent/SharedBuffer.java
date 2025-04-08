package concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class SharedBuffer {

    private final int capacity;
    private final Queue<String> table = new ArrayDeque<>();

    private final Lock lock = new ReentrantLock();
    private final Condition chefCondition = lock.newCondition();
    private final Condition customerCondition = lock.newCondition();

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public void produce(String food) {
        lock.lock();
        try {
            while (table.size() == capacity) {
                log.info("[FULL] 테이블이 가득 찼습니다 / table: {}", table);
                try {
                    chefCondition.await();
                    log.info("요리사 깨어남!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            table.offer(food);
            log.info("[COOK] {} 요리 완료 / table: {}", food, table);
            customerCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            while (table.isEmpty()) {
                log.info("[EMPTY] 음식 없음 / table: {}", table);
                try {
                    customerCondition.await();
                    log.info("손님 깨어남!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String food = table.poll();
            log.info("[EAT] {} 식사 완료 / table: {}", food, table);
            chefCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}