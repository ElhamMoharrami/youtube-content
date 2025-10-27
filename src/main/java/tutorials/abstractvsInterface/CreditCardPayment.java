package tutorials.abstractvsInterface;

public class CreditCardPayment extends Payment implements Refundable {

    @Override
    void processPayment(double amount) {
        System.out.println("Payment of $" + amount +
                " is approved. Processed by credit card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded $"+amount+" to the credit card");
    }
}
