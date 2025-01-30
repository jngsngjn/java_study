package design.patterns.template_callback;

public class UpperCaseCallback implements FileCallback {
    @Override
    public void process(String line) {
        System.out.println("대문자로 변환: " + line.toUpperCase());
    }
}