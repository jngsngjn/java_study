package design_patterns.decorator;

import design_patterns.decorator.code.client.Customer;
import design_patterns.decorator.code.component.BasicFood;
import design_patterns.decorator.code.component.Food;
import design_patterns.decorator.code.decorator.CheeseDecorator;
import design_patterns.decorator.code.decorator.DrinkDecorator;
import design_patterns.decorator.code.decorator.FriesDecorator;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("🙋🏻‍♂️ [1] 기본 버거 주문");
        basicBurgerCustomer().eat();

        System.out.println("\n🙋🏻‍♂️ [2] 치즈 버거 주문");
        cheeseBurgerCustomer().eat();

        System.out.println("\n🙋🏻‍♂️ [3] 풀세트 주문");
        fullSetCustomer().eat();
    }

    public static Customer basicBurgerCustomer() {
        Food basicBurger = new BasicFood();
        return new Customer(basicBurger);
    }

    public static Customer cheeseBurgerCustomer() {
        Food cheeseBurger = new CheeseDecorator(new BasicFood());
        return new Customer(cheeseBurger);
    }

    public static Customer fullSetCustomer() {
        Food fullSet = new DrinkDecorator(new FriesDecorator(new CheeseDecorator(new BasicFood())));
        return new Customer(fullSet);
    }
}