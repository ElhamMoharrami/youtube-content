package miniProjects.calculatorProject;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        runConsoleCalculator();
    }
    
    private static void runConsoleCalculator() {
        Scanner scanner = new Scanner(System.in);
        double firstNumber, secondNumber, result;
        char operator;

        System.out.println("Enter first number: ");
        firstNumber = scanner.nextDouble();

        System.out.println("Enter operator (+,-,*,/) :");
        operator = scanner.next().charAt(0);

        System.out.println("Enter second number: ");
        secondNumber = scanner.nextDouble();

        switch (operator) {
            case '+': result = firstNumber + secondNumber; break;
            case '-': result = firstNumber - secondNumber; break;
            case '*': result = firstNumber * secondNumber; break;
            case '/':
                if(secondNumber !=0 ) result=firstNumber/secondNumber;
                else{
                    System.out.println("Error: Division by zero!");
                    return;
                }
                break;
                default:
                    System.out.println("Error: Invalid operator!");
                    return;
        }
        System.out.println("Result: " + result);
    }
}
