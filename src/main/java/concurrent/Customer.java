package concurrent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static util.ThreadUtil.sleep;

@Slf4j
@RequiredArgsConstructor
public class Customer implements Runnable {

    private final SharedBuffer sharedBuffer;

    @Override
    public void run() {
        while (true) {
            eat();
        }
    }

    public void eat() {
        sleep(100);
        sharedBuffer.consume();
    }
}