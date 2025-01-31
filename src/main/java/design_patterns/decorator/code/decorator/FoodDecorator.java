package design_patterns.decorator.code.decorator;

import design_patterns.decorator.code.component.Food;

// 3. 데코레이터 부모 클래스 (Decorator)
public abstract class FoodDecorator implements Food {

    protected Food decoratedFood;

    public FoodDecorator(Food food) {
        this.decoratedFood = food;
    }

    @Override
    public String getDescription() {
        return decoratedFood.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedFood.getCost();
    }
}