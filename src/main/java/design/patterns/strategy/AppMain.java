package design.patterns.strategy;

public class AppMain {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.pay(10000, new CreditCardPayment("1234-5678-9012-3456"));
        context.pay(20000, new PayPalPayment("user@example.com"));
        context.pay(30000, new BitcoinPayment("bitcoin id"));
    }
}