package design_patterns.decorator.code.decorator;

import design_patterns.decorator.code.component.Food;

// Concrete Decorator
public class CheeseDecorator extends FoodDecorator {

    public CheeseDecorator(Food food) {
        super(food);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " 🧀 + 치즈 추가";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1000;
    }
}