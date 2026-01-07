import java.time.LocalDateTime;

public class Task {
    private int id = 0;
    private String description;
    private enum status {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private status status;

    public void createTask(String description) {
        //i need function to will keep track of id number and status
        this.id = id++;
        this.description = description;
        this.status = status.PENDING;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}