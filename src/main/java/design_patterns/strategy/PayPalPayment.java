package design_patterns.strategy;

import lombok.RequiredArgsConstructor;

// 페이팔
@RequiredArgsConstructor
public class PayPalPayment implements PaymentStrategy {

    private final String email;

    @Override
    public void pay(int amount) {
        System.out.println(amount + "원을 PayPal 계정(" + email + ")으로 결제합니다.");
    }
}