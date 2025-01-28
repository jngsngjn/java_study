package design.patterns.strategy;

public class PaymentContext {

    // 결제 수행
    public void pay(int amount, PaymentStrategy paymentStrategy) {
        paymentStrategy.pay(amount);
    }
}