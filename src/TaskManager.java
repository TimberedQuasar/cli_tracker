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

    public Task updateTask (int id, String newDescription) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.description = newDescription;
                task.updatedAt = java.time.LocalDateTime.now();
                return task;
            }
        }
        throw new IllegalArgumentException("Task with ID " + id + " not found.");
    }

    public Task deleteTask (int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                return task;
            }
        }
        throw new IllegalArgumentException("Task with ID " + id + " not found.");
    }


}
