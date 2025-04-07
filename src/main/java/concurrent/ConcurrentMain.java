package concurrent;

import java.util.List;

public class ConcurrentMain {

    public static final List<String> FOOD_LIST = List.of(
            "햄버거", "떡볶이", "돈까스", "짜장면", "치킨"
    );

    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer(2);
        Chef chef = new Chef(sharedBuffer);
        Customer customer = new Customer(sharedBuffer);

        startChef(chef);
        startCustomer(customer);
    }

    private static void startChef(Chef chef) {
        for (int i = 1; i <= 3; i++) {
            Thread thread = new Thread(chef, chef.getClass().getSimpleName() + i);
            thread.start();
        }
    }

    private static void startCustomer(Customer customer) {
        for (int i = 1; i <= 3; i++) {
            Thread thread = new Thread(customer, customer.getClass().getSimpleName() + i);
            thread.start();
        }
    }
}