package miniProjects.habitTracker.repository;

import miniProjects.habitTracker.model.Habit;

import java.util.*;

public class InMemoryHabitRepository implements HabitRepository {
    private final Map<Integer,Habit> storage=new HashMap<>();
    private int idCounter=1;

    @Override
    public Habit save(Habit habit) {
        Habit toStore=habit;
        if(habit.getId()==0){
            toStore=new Habit(
                    idCounter++,
                    habit.getName(),
                    habit.getDescription()
                    ,habit.getDateCreated()
                    ,habit.getStreak());
        }
        storage.put(toStore.getId(),toStore);
        return toStore;
    }

    @Override
    public Optional<Habit> findById(int id) {
       return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Habit> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(int id) {
        storage.remove(id);
    }
}
