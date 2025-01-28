package design.patterns.strategy;

import lombok.RequiredArgsConstructor;

// 비트코인
@RequiredArgsConstructor
public class BitcoinPayment implements PaymentStrategy {

    private final String walletId;

    @Override
    public void pay(int amount) {
        System.out.println(amount + "원을 비트코인 지갑(" + walletId + ")으로 결제합니다.");
    }
}