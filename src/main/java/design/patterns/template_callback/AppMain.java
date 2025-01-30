package design.patterns.template_callback;

public class AppMain {
    public static void main(String[] args) {
        FileProcessor processor = new FileProcessor();
        String filePath = "file/sample.txt"; // 테스트할 파일

        // ✅ 콜백1: 읽은 파일 내용을 모두 대문자로 변환
        processor.processFile(filePath, line ->
                System.out.println("대문자로 변환: " + line.toUpperCase())
        );

        // ✅ 콜백2: 파일의 단어 개수 세기
        processor.processFile(filePath, line -> {
            int wordCount = line.split("\\s+").length;
            System.out.println("단어 개수: " + wordCount);
        });

        // ✅ 콜백3: "특정 단어 포함 여부 확인" (예: "error" 찾기)
        processor.processFile(filePath, line -> {
            if (line.contains("error")) {
                System.out.println("에러 메시지 발견: " + line);
            }
        });

        processor.processFile(filePath, new UpperCaseCallback());
    }
}