package design.patterns.template_method;

// 차 클래스
public class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("찻잎을 우려냅니다.");
    }

    @Override
    protected void addCondiments() {
        System.out.println("레몬을 추가합니다.");
    }
}