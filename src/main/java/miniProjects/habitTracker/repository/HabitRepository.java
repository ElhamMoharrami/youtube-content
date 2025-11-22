package miniProjects.habitTracker.repository;

import miniProjects.habitTracker.model.Habit;

import java.util.List;
import java.util.Optional;

public interface HabitRepository {
    Habit save(Habit habit);
    Optional<Habit> findById(int id);
    List<Habit> findAll();
    void deleteById(int id);
}
