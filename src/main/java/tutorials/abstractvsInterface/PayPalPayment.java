package tutorials.abstractvsInterface;

public class PayPalPayment extends Payment implements Refundable {

    @Override
    void processPayment(double amount) {
        System.out.println("Payment of $" + amount +
                " is approved. Processed by PayPal.");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded $"+amount+" to the PayPal");

    }
}
