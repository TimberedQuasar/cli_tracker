import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TaskStorage {
    private static final String FILE_NAME = "tasks.json";

    public static void ensureFileExists(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException("Failed to create file: " + filePath);
            }
        }
    }

    public void saveTasks(List<Task> tasks) throws IOException {
        TaskStorage.ensureFileExists(FILE_NAME);
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        writer.write("{\n  \"tasks\": [\n");
        for (int i = 0; i < tasks.size(); i++) {
            writer.write(serializeTask(tasks.get(i)));
            if (i < tasks.size() - 1) {
                writer.write(",\n");
            }
        }
        writer.write("]");
        writer.close();
    }

    // Serializacja pojedynczego zadania do JSON
    private String serializeTask(Task task) {
        return String.format(
                "{ \n\"id\": %d,\n \"description\": \"%s\",\n \"status\": \"%s\",\n \"createdAt\": \"%s\",\n \"updatedAt\": \"%s\"\n}",
                task.getId(),
                task.getDescription(),
                task.getStatus().name(),
                task.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                task.getUpdatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );
    }
}