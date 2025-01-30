package design.patterns.strategy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentContext {

    private final PaymentStrategy strategy;

    // 결제 수행
    public void pay(int amount) {
        strategy.pay(amount);
    }
}