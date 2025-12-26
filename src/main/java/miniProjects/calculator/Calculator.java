package miniProjects.calculator;

import java.util.Scanner;

public class Calculator {
 private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();

            int choice=readInt("Select an option: ");

            if(choice==5){
                System.out.println("Exiting calculator.");
                break;
            }

            double a=readDouble("Enter first number: ");
            double b=readDouble("Enter second number");

            try{
                double result=calculate(choice,a,b);
                System.out.println("Result: "+result);
            }catch(IllegalArgumentException | ArithmeticException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }

    private static void printMenu(){
        System.out.println("Calculator");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");
    }

    private static double calculate(int choice, double a, double b){
        return switch (choice){
            case 1-> a+b;
            case 2-> a-b;
            case 3-> a*b;
            case 4->{
                if(b==0){
                    throw new ArithmeticException("Divide by zero");
                }
                yield a/b;
            }
            default-> throw new IllegalArgumentException("Invalid choice");
        };
    }

    private static double readDouble(String message){
        System.out.println(message);
        return scanner.nextDouble();
    }

    private static int readInt(String message){
        System.out.println(message);
        return scanner.nextInt();
    }
}
