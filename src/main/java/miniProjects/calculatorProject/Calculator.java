package miniProjects.calculatorProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Welcome to Calculator!");
        System.out.println("1 : console calculator");
        System.out.println("2 : GUI calculator");
        System.out.println("select (1 or 2)");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input; launching GUI...");
            choice = 2;
        }
        if (choice == 1) {
            runConsoleCalculator();
        } else {
            SwingUtilities.invokeLater(() -> new CalculatorAppGUI());
        }
    }

    private static void runConsoleCalculator() {
        Scanner scanner = new Scanner(System.in);
        double firstNumber=0, secondNumber=0, result=0, memory=0;
        char operator;

        while (true) {
            System.out.println("Console calculator (type Q to quit)");

            System.out.println("Memory: "+ memory);
            System.out.println("Options: Enter expression (e.g, 2+3)," +
                    "M+ (add display to memory)" +
                    "M- (subtract display from memory)" +
                    "MR (recall memory)" +
                    "MC (clear memory)" +
                    "Q (quit)");

            System.out.println("Enter: ");
            String input=scanner.nextLine().trim();
            if (input.equalsIgnoreCase("Q")) break;

            try{
                if(input.equalsIgnoreCase("MC")){
                    memory=0;
                    System.out.println("Memory cleared.");
                    continue;
                } else if (input.equalsIgnoreCase("MR")) {
                    System.out.println("Memory: "+memory);
                    continue;
                }else if (input.equalsIgnoreCase("M+")) {
                    memory += result;
                    System.out.println("Added to memory: "+result);
                    continue;
                }else if (input.equalsIgnoreCase("M-")) {
                    memory -= result;
                    System.out.println("Subtracted from memory: "+result);
                    continue;
                }
                String[] parts=input.split(" ");
                if (parts.length != 3) {
                    System.out.println("Invalid input format");
                    continue;
                }
                firstNumber=Double.parseDouble(parts[0]);
                operator=parts[1].charAt(0);
                secondNumber=Double.parseDouble(parts[2]);

                switch (operator) {
                    case '+': result = firstNumber + secondNumber; break;
                    case '-': result = firstNumber - secondNumber; break;
                    case '*': result = firstNumber * secondNumber; break;
                    case '/':
                        if(secondNumber==0){
                            System.out.println("Error: Division by zero");
                            continue;
                        }
                        result = firstNumber / secondNumber;
                        break;
                    default:
                        System.out.println("Invalid operator");
                        continue;
                }
                System.out.println("Result: "+result);
            }catch (NumberFormatException ex){
                System.out.println("Invalid number entered");
            }
        }
    }

    static class CalculatorAppGUI extends JFrame implements ActionListener {
        private JFormattedTextField display;
        private double firstNumber = 0, secondNumber = 0, result = 0, memory = 0;
        private char operator = ' ';

        public CalculatorAppGUI() {
            setTitle("Enhanced Calculator");
            setSize(350, 450);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            display = new JFormattedTextField();
            display.setEditable(false);
            display.setFont(new Font("Arial", Font.BOLD, 24));
            add(display, BorderLayout.NORTH);//set this to North

            String[] buttons = {
                    "MC", "MR", "M+", "M-",
                    "7", "8", "9", "/"
                    , "4", "5", "6", "*"
                    , "1", "2", "3", "-"
                    ,"0","C","=","+"
            };

            JPanel panel=new JPanel(new GridLayout(5,4,10,10));
            for (String text : buttons) {
                JButton button = new JButton(text);
                button.setFont(new Font("Arial", Font.BOLD, 18));
                button.addActionListener(this);
                panel.add(button);//forgot this line
            }
            add(panel);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            String cmd=e.getActionCommand();
            try{
                if("0123456789".contains(cmd)){
                    display.setText(display.getText()+cmd);
                }else if("+-*/".contains(cmd)){
                    firstNumber = Double.parseDouble(display.getText());
                    operator = cmd.charAt(0);
                    display.setText("");
                } else if ("=".contains(cmd)) {
                    secondNumber = Double.parseDouble(display.getText());
                    switch (operator) {
                        case '+': result = firstNumber + secondNumber;break;
                        case '-': result = firstNumber - secondNumber;break;
                        case '*': result = firstNumber * secondNumber;break;
                        case '/':
                            if(secondNumber ==0){
                                display.setText("Div by zero");
                                return;
                            }
                            result = firstNumber / secondNumber;
                            break;
                    }
                    display.setText(" " + result);//remove the text
                } else if ("C".contains(cmd)) {
                    display.setText("");
                    firstNumber=secondNumber=result=0;
                    operator=' ';
                } else if ("MC".contains(cmd)) {
                    memory=0;
                }else if ("MR".contains(cmd)) {
                    display.setText(""+memory);
                } else if ("M+".contains(cmd)) {
                    if(!display.getText().isEmpty()){
                        memory+=Double.parseDouble(display.getText());
                    }
                } else if ("M-".contains(cmd)) {
                    if(!display.getText().isEmpty()){
                        memory-=Double.parseDouble(display.getText());
                    }

                }
            }catch (NumberFormatException nfe){
                display.setText("Error");
            }
        }
    }
}
