public class AdapterPatternTest {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPalPaymentGateway());
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripePaymentGateway());

        payPalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(200.0);
    }
}
