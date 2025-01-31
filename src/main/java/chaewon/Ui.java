package chaewon;

import tasks.Task;

/**
 * Represents the user interface of the application.
 */
public class Ui {

    /**
     * Prints a welcome message to the console.
     */
    public void welcome() {
        printUnderscore();
        System.out.println("Hello! I'm Kim Chaewon!");
        System.out.println("What can I do for you?");
        printUnderscore();
    }

    /**
     * Prints a hello message to the console.
     */
    public void hello() {
        printUnderscore();
        System.out.println("Hello! I'm Chaewon, "
                + "leader of Korean girl group Le Sserafim!");
        printUnderscore();
    }

    /**
     * Prints a goodbye message to the console.
     */
    public void goodbye() {
        printUnderscore();
        System.out.println("Bye! Get an A for this mod and "
                + "I'll reunite IZ*ONE for you <3");
        printUnderscore();
    }

    /**
     * Prints a message to the console.
     *
     * @param message The message to be printed.
     */
    public void printMessage(String message) {
        printUnderscore();
        System.out.println(message);
        printUnderscore();
    }

    /**
     * Marks a task as done.
     * @param task The task to be marked as done.
     * @param <T> The type of task.
     */
    public <T extends Task> void markedTask(T task) {
        printUnderscore();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task.toString());
        printUnderscore();
    }

    /**
     * Marks a task as not done.
     * @param task The task to be marked as not done.
     * @param <T> The type of task.
     */
    public <T extends Task> void unmarkedTask(T task) {
        printUnderscore();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(task.toString());
        printUnderscore();
    }

    /**
     * Adds a task to the list of tasks.
     * @param task The task to be added.
     * @param size The size of the list of tasks.
     * @param <T> The type of task.
     */
    public <T extends Task> void addedTask(T task, int size) {
        printUnderscore();
        System.out.println("Got it. I've added this task:");
        System.out.println(task.toString());
        System.out.println("Now you have " + size + " tasks in the list.");
        printUnderscore();
    }

    /**
     * Deletes a task from the list of tasks.
     * @param task The task to be deleted.
     * @param size The size of the list of tasks.
     * @param <T> The type of task.
     */
    public <T extends Task> void deletedTask(T task, int size) {
        printUnderscore();
        System.out.println("Noted. I've removed this task:");
        System.out.println(task.toString());
        System.out.println("Now you have " + size + " tasks in the list.");
        printUnderscore();
    }

    /**
     * Shows the list of tasks.
     * @param tasks The list of tasks.
     */
    public void showTasks(TaskList tasks) {
        printUnderscore();
        if (tasks.getNumTasks() == 0) {
            System.out.println("You have no tasks in your list. Slay!");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < tasks.getNumTasks(); i++) {
                System.out.println((i + 1) + ". " + tasks.getTasks().get(i).toString());
            }
        }
        printUnderscore();
    }

    /**
     * Prints the tasks that match the keyword.
     *
     * @param tasks The list of tasks that match the keyword.
     */
    public void showFoundTasks(TaskList tasks) {
        printUnderscore();
        if (tasks.getNumTasks() == 0) {
            System.out.println("No matching tasks found.");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < tasks.getNumTasks(); i++) {
                System.out.println((i + 1) + ". " + tasks.getTasks().get(i).toString());
            }
        }
        printUnderscore();
    }

     * Prints a line of underscores to the console.
     */
    public static void printUnderscore() {
        System.out.println("____________________________________________________________");
    }
}
