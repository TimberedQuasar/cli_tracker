import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the CLI Task Manager!");
        System.out.println("Type 'help' for a list of commands.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] commandParts = input.split(" ", 2); // Split command + argument
            String command = commandParts[0].toLowerCase();
            String arguments = commandParts.length > 1 ? commandParts[1] : "";

            try {
                switch (command) {
                    case "add":
                        Task task = taskManager.addTask(arguments);
                        System.out.println("Task added: ID = " + task.getId());
                        break;

                    case "update":
                        String[] updateParts = arguments.split(" ", 2);
                        int updateId = Integer.parseInt(updateParts[0]);
                        String newDescription = updateParts[1];
                        taskManager.updateTask(updateId, newDescription);
                        System.out.println("Task updated: ID = " + updateId);
                        break;

                    case "delete":
                        int deleteId = Integer.parseInt(arguments);
                        taskManager.deleteTask(deleteId);
                        System.out.println("Task deleted: ID = " + deleteId);
                        break;

                   case "mark-in-progress":
                        int inProgressId = Integer.parseInt(arguments);
                        taskManager.markTaskInProgress(inProgressId);
                        System.out.println("Task marked as 'in progress': ID = " + inProgressId);
                        break;

                    case "mark-done":
                        int doneId = Integer.parseInt(arguments);
                        taskManager.markTaskDone(doneId);
                        System.out.println("Task marked as 'done': ID = " + doneId);
                        break;

                    case "list":
                        if (arguments.isEmpty() || arguments.equals("all")) {
                            System.out.println("All tasks:");
                            taskManager.listAllTasks().forEach(System.out::println);
                        } else {
                            Task.Status status = Task.Status.valueOf(arguments.toUpperCase());
                            System.out.println("Tasks with status '" + arguments + "':");
                            taskManager.listTasksByStatus(status).forEach(System.out::println);
                        }
                        break;

                    case "exit":
                        System.out.println("Exiting the Task Manager. Goodbye!");
                        return;

                    case "help":
                        printHelp();
                        break;

                    default:
                        System.out.println("Unknown command. Type 'help' for a list of commands.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void printHelp() {
        System.out.println("Commands:");
        System.out.println("  add <description>          - Add a new task");
        System.out.println("  update <id> <description>  - Update an existing task's description");
        System.out.println("  delete <id>                - Delete a task by ID");
        System.out.println("  mark-in-progress <id>      - Mark a task as 'in progress'");
        System.out.println("  mark-done <id>             - Mark a task as 'done'");
        System.out.println("  list                       - List all tasks");
        System.out.println("  list <status>              - List tasks by status (todo, in-progress, done)");
        System.out.println("  exit                       - Exit the task manager");
        System.out.println("  help                       - Show this help message");
    }
}