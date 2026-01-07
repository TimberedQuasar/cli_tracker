import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public Task addTask (String description) {
        Task task = new Task(description);
        tasks.add(task);
        return task;
    }
}
