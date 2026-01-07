import java.io.IOException;
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

        TaskStorage storage = new TaskStorage();
        try {
            storage.saveTasks(tasks);
        } catch (IOException e) {
            System.out.println("Failed to save the task: " + e.getMessage());
        }
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

    public Task markTaskInProgress(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.status = Task.Status.IN_PROGRESS;
                task.updatedAt = java.time.LocalDateTime.now();
                return task;
            }
        }
        throw new IllegalArgumentException("Task with ID " + id + " not found.");
    }

    public Task markTaskDone(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.status = Task.Status.COMPLETED;
                task.updatedAt = java.time.LocalDateTime.now();
                return task;
            }
        }
        throw new IllegalArgumentException("Task with ID " + id + " not found.");
    }

    public List<Task> listAllTasks() {
        return tasks;
    }

    public List<Task> listTasksByStatus(Task.Status status) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.status == status) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }


}
