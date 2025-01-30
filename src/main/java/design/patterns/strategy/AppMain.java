package design.patterns.strategy;

public class AppMain {
    public static void main(String[] args) {
        CreditCardPayment creditCardPayment = new CreditCardPayment("1234-5678-9012-3456");
        PaymentContext context1 = new PaymentContext(creditCardPayment);
        context1.pay(10000);

        PayPalPayment payPalPayment = new PayPalPayment("user@example.com");
        PaymentContext context2 = new PaymentContext(payPalPayment);
        context2.pay(20000);

        BitcoinPayment bitcoinPayment = new BitcoinPayment("bitcoin id");
        PaymentContext context3 = new PaymentContext(bitcoinPayment);
        context3.pay(30000);
    }
}