package tutorials.abstractvsInterface;

public class Main {
    public static void main(String[] args) {
        Payment p1=new CreditCardPayment();
        Payment p2= new PayPalPayment();

        p1.processPayment(100.0);
        p2.processPayment(50.0);

        Refundable r1=new CreditCardPayment();
        r1.refund(30.0);
        Refundable r2=new PayPalPayment();
        r2.refund(20.0);
    }
}
