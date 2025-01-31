package design_patterns.decorator.code.decorator;

import design_patterns.decorator.code.component.Food;

// Concrete Decorator
public class FriesDecorator extends FoodDecorator {

    public FriesDecorator(Food food) {
        super(food);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " 🍟 + 감자튀김 추가";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2000;
    }
}