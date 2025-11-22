package miniProjects.habitTracker.service;

import miniProjects.habitTracker.dto.HabitCreateRequest;
import miniProjects.habitTracker.model.Habit;
import miniProjects.habitTracker.repository.HabitRepository;

import java.time.LocalDate;
import java.util.List;

public class HabitService {
    private HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public Habit createHabit(HabitCreateRequest habit) {
        Habit newHabit=new Habit(
                0,
                habit.getName(),
                habit.getDescription(),
                LocalDate.now(),
                0
        );
        return habitRepository.save(newHabit);
    }

    public List<Habit> listHabits() {
        return habitRepository.findAll();
    }

    public Habit incrementStreak(int id) {
        Habit habit = habitRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Habit not found"));
        Habit updatedHabit = habit.withStreak(habit.getStreak()+1);
        return habitRepository.save(updatedHabit);
    }

    public void deleteHabit(int id) {
        habitRepository.deleteById(id);
    }
}
