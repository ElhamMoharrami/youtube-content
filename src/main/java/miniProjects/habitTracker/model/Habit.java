package miniProjects.habitTracker.model;

import java.time.LocalDate;
import java.util.Objects;

public final class Habit {
    private final int id;
    private final String name;
    private final String description;
    private final LocalDate dateCreated;
    private final int streak;

    public Habit(int id, String name, String description, LocalDate dateCreated, int streak) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.streak = streak;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public int getStreak() {
        return streak;
    }

    public Habit withStreak(int newStreak) {
        return new Habit(id, name, description, dateCreated, newStreak);
    }


    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Habit)) return false;
        Habit other = (Habit) o;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
