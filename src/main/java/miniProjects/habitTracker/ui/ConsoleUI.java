package miniProjects.habitTracker.ui;

import miniProjects.habitTracker.dto.HabitCreateRequest;
import miniProjects.habitTracker.model.Habit;
import miniProjects.habitTracker.service.HabitService;

import java.util.Scanner;

public class ConsoleUI {
    private final HabitService habitService;

    public ConsoleUI(HabitService habitService) {
        this.habitService = habitService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Habit Tracker");
            System.out.println("1. Create Habit");
            System.out.println("2. List Habits");
            System.out.println("3. Increment streak");
            System.out.println("4. Delete Habit");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            int choice= Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1->{
                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Description: ");
                    String description = scanner.nextLine();
                    Habit habit = habitService.createHabit(new HabitCreateRequest(name, description));
                    System.out.println("Habit created with ID: " + habit.getId());
                }
                case 2->{
                    for(Habit habit: habitService.listHabits()){
                        System.out.println(habit.getId()
                                +": "+habit.getName()+ " | streak="+habit.getStreak());
                    }
                }
                case 3->{
                    System.out.println("Habit ID: ");
                    int habitId = Integer.parseInt(scanner.nextLine());
                    Habit updated=habitService.incrementStreak(habitId);
                    System.out.println("Habit updated to: "+updated.getStreak());
                }
                case 4->{
                    System.out.println("Habit ID: ");
                    int habitId = Integer.parseInt(scanner.nextLine());
                    habitService.deleteHabit(habitId);
                    System.out.println("Habit deleted");
                }
                case 5->{
                    System.out.println("Bye");
                    return;
                }
                default->
                    System.out.println("Invalid choice");
            }
        }
    }
}
