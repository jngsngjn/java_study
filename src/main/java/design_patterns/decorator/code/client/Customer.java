package design_patterns.decorator.code.client;

import design_patterns.decorator.code.component.Food;

// 데코레이터 패턴 클라이언트
public class Customer {

    private final Food food;

    public Customer(Food food) {
        this.food = food;
    }

    public void eat() {
        String result = food.getDescription();
        double cost = food.getCost();
        System.out.println("주문한 음식: " + result);
        System.out.println("총 가격: " + cost);
    }
}