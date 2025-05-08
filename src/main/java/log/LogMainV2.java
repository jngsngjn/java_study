package log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogMainV2 {
    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            log.info("Hello, " + i);
        }

        long endTimeMillis = System.currentTimeMillis();
        log.error("소요 시간: {}ms", endTimeMillis - startTimeMillis);
    }
}