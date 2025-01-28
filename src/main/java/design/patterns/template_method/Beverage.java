package design.patterns.template_method;

public abstract class Beverage {

    // 템플릿 메서드 (전체 흐름 정의)
    public final void prepareRecipe() {
        boilWater();      // 공통
        brew();           // 하위 클래스에서 구현
        pourInCup();      // 공통
        addCondiments();  // 하위 클래스에서 구현
    }

    private void boilWater() {
        System.out.println("물을 끓입니다.");
    }

    private void pourInCup() {
        System.out.println("컵에 붓습니다.");
    }

    protected abstract void brew();

    protected abstract void addCondiments();
}