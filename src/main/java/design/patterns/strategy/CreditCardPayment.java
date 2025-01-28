package design.patterns.strategy;

import lombok.RequiredArgsConstructor;

// 신용카드
@RequiredArgsConstructor
public class CreditCardPayment implements PaymentStrategy {

    private final String cardNumber;

    @Override
    public void pay(int amount) {
        System.out.println(amount + "원을 신용카드(" + cardNumber + ")로 결제합니다.");
    }
}