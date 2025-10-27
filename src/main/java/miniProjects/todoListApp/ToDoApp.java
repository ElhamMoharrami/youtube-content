package miniProjects.todoListApp;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
    private static ArrayList<Task> tasks=new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do{
            System.out.println("---To-Do List---");
            System.out.println("1. Add Task");
            System.out.println("2. View Task");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("0. Exit Program");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1-> addTask(scanner);
                case 2-> viewTasks();
                case 3-> markTaskDone(scanner);
                case 4-> deleteTask(scanner);
                case 0-> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice");
            }
        }while (choice !=0 );
    }

    private static void addTask(Scanner scanner) {
        System.out.println("Enter task: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added");
    }

    private static void viewTasks() {
        if(tasks.isEmpty()){
            System.out.println("No tasks found");
        }else{
            for(int i=0; i<tasks.size(); i++){
                System.out.println((i+1) + ". " + tasks.get(i));
            }
        }
    }

    private static void markTaskDone(Scanner scanner) {
        viewTasks();
        if(tasks.isEmpty()) return;

        System.out.println("Enter task number to mark done: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();

        if(taskNumber>0 && taskNumber<=tasks.size()){
            tasks.get(taskNumber-1).isDone = true;
            System.out.println("Task marked done successfully");
        }else{
            System.out.println("Invalid task number");
        }
    }

    private static void deleteTask(Scanner scanner) {
        viewTasks();
        if(tasks.isEmpty()) return;
        System.out.println("Enter task number to delete: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();
        if(taskNumber>0 && taskNumber<=tasks.size()){
            tasks.remove(taskNumber-1);
            System.out.println("Task deleted successfully");
        }else {
            System.out.println("Invalid task number");
        }
    }
}
