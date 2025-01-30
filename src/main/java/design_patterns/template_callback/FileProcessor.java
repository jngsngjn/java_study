package design_patterns.template_callback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// 템플릿 클래스: 파일을 한 줄씩 읽고, 후처리(콜백)를 실행하는 역할
public class FileProcessor {

    public void processFile(String filePath, FileCallback callback) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) { // 파일을 한 줄씩 읽음 (공통 로직)
                callback.process(line); // 콜백 실행 (변경 가능한 부분)
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}