package design_patterns.decorator.code.decorator;

import design_patterns.decorator.code.component.Food;

// Concrete Decorator
public class DrinkDecorator extends FoodDecorator {

    public DrinkDecorator(Food food) {
        super(food);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " 🥤 + 음료 추가";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1500;
    }
}