package miniProjects.todoListApp;

public class Task {
    String description;
    boolean isDone;

    Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    @Override
    public String toString() {
        return (isDone ? "[Done] ":"[Undone] ")+description;
    }
}
