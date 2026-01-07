import java.time.LocalDateTime;

public class Task {
    private final int id;
    private final String description;
    private Status status;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private enum Status {
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