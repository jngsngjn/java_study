package concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

@Slf4j
public class SharedBuffer {

    private final int capacity;

    // 생산자와 소비자가 공유하는 버퍼
    private final Queue<String> table = new ArrayDeque<>();

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(String food) {
        if (table.size() == capacity) {
            log.info("[FULL] 테이블이 가득 찼습니다 / table: {}", table);
            return;
        }
        table.offer(food);
        log.info("[COOK] {} 요리 완료 / table: {}", food, table);
    }

    public synchronized void consume() {
        if (table.isEmpty()) {
            log.info("[EMPTY] 음식 없음 / table: {}", table);
        } else {
            String food = table.poll();
            log.info("[EAT] {} 식사 완료 / table: {}", food, table);
        }
    }
}