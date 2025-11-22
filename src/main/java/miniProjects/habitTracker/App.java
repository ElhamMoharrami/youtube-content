package miniProjects.habitTracker;

import miniProjects.habitTracker.repository.InMemoryHabitRepository;
import miniProjects.habitTracker.service.HabitService;
import miniProjects.habitTracker.ui.ConsoleUI;

public class App {
    public static void main(String[] args) {
        HabitService service= new HabitService(new InMemoryHabitRepository());
        ConsoleUI ui=new ConsoleUI(service);
        ui.start();
    }
}
