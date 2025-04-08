package concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Slf4j
public class SharedBufferBlockingQueue {

    private final BlockingQueue<String> table;

    public SharedBufferBlockingQueue(int capacity) {
        this.table = new ArrayBlockingQueue<>(capacity);
    }

    public void produce(String food) {
        try {
            table.put(food);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void consume() {
        try {
            String food = table.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}