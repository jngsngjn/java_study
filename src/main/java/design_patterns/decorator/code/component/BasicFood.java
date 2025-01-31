package design_patterns.decorator.code.component;

// 2. 기본 음식(Concrete Component)
public class BasicFood implements Food {

    @Override
    public String getDescription() {
        return "🍔 기본 버거";
    }

    @Override
    public double getCost() {
        return 5000;
    }
}