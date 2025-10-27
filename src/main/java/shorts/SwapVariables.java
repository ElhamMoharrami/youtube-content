package shorts;

public class SwapVariables {
    public static void main(String[] args) {
        //The Classic Way
       /* int a = 5;
        int b = 10;
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("temp = " + temp);*/



        // Without a Temporary Variable
        int a = 5;
        int b = 10;

        a = a + b; // 15
        b = a - b; // 5
        a = a - b; // 10
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
