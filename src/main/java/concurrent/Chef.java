package concurrent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

import static concurrent.ConcurrentMain.FOOD_LIST;
import static util.ThreadUtil.sleep;

@Slf4j
@RequiredArgsConstructor
public class Chef implements Runnable {

    private final SharedBuffer sharedBuffer;
    private final Random random = new Random();

    @Override
    public void run() {
        while (true) {
            cook();
        }
    }

    public void cook() {
        sharedBuffer.produce(selectFood());
    }

    private String selectFood() {
        sleep(100);
        return FOOD_LIST.get(random.nextInt(FOOD_LIST.size()));
    }
}