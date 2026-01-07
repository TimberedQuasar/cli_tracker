import java.time.LocalDateTime;

public class Task {
    private int id = 0;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private enum Status {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }

    public void createTask(String description) {
        //i need function to will keep track of id number and status
        this.id = id++;
        this.description = description;
        this.status = Status.PENDING;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}