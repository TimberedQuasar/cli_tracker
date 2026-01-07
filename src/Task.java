import java.time.LocalDateTime;

public class Task {
    private final int id;
    public String description;
    public Status status;
    private final LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public enum Status {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }

    private static int idCounter = 0;

    public Task(String description) {
        //i need function to will keep track of id number and status
        this.id = ++idCounter;
        this.description = description;
        this.status = Status.PENDING;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    private Status getStatus() {
        return status;
    }

}