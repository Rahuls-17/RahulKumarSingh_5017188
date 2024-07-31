public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        paymentContext.setPaymentStrategy(new CreditCardPayment());
        paymentContext.executePayment(100.0);

        paymentContext.setPaymentStrategy(new PayPalPayment());
        paymentContext.executePayment(200.0);
    }
}
