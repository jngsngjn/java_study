package design.patterns.template_callback;

// 콜백 인터페이스: 파일에서 읽을 데이터를 처리하는 역할
public interface FileCallback {
    void process(String line);
}