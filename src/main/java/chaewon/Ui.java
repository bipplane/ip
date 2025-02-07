package chaewon;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import tasks.Task;

/**
 * Represents the user interface of the application.
 */
public class Ui {
    private final List<String> helloMessages = Arrays.asList(
        "Hello! I'm Chaewon, leader of Korean girl group Le Sserafim!",
        "Hi there! Chaewon here, ready to assist you!",
        "Hey! It's Chaewon, how can I help you today?",
        "Yo! It's Chaewon-dayo!"
    );
    private final Random random = new Random();

    /**
     * Returns a welcome message.
     */
    public String welcome() {
        return "Hello! I'm Kim Chaewon!\n"
                + "What can I do for you?";
    }

    /**
     * Returns a hello message.
     */
    public String hello() {
        int index = random.nextInt(helloMessages.size());
        return helloMessages.get(index);
    }

    /**
     * Returns a goodbye message.
     */
    public String goodbye() {
        return "Bye! Get an A for this mod and I'll reunite IZ*ONE for you <3";
    }

    /**
     * Returns a message.
     *
     * @param message The message to be returned.
     * @return The message.
     */
    public String printMessage(String message) {
        assert message != null : "Message should not be null";
        return message;
    }

    /**
     * Marks a task as done.
     * @param task The task to be marked as done.
     * @param <T> The type of task.
     * @return The string of the task that was marked as done.
     */
    public <T extends Task> String markedTask(T task) {
        assert task != null : "Task should not be null";
        return "Nice! I've marked this task as done:\n"
                + task.toString();
    }

    /**
     * Marks a task as not done.
     * @param task The task to be marked as not done.
     * @param <T> The type of task.
     * @return The string of the task that was marked as not done.
     */
    public <T extends Task> String unmarkedTask(T task) {
        assert task != null : "Task should not be null";
        return "OK, I've marked this task as not done yet:\n"
                + task.toString();
    }

    /**
     * Adds a task to the list of tasks.
     * @param task The task to be added.
     * @param size The size of the list of tasks.
     * @param <T> The type of task.
     * @return The string of the task that was added.
     */
    public <T extends Task> String addedTask(T task, int size) {
        assert task != null : "Task should not be null";
        assert size >= 0 : "Size should be non-negative";
        return "Got it. I've added this task:\n"
                + task.toString() + "\n"
                + "Now you have " + size + " tasks in the list.";
    }

    /**
     * Deletes a task from the list of tasks.
     * @param task The task to be deleted.
     * @param size The size of the list of tasks.
     * @param <T> The type of task.
     * @return The string of the task that was deleted.
     */
    public <T extends Task> String deletedTask(T task, int size) {
        assert task != null : "Task should not be null";
        assert size >= 0 : "Size should be non-negative";
        return "Noted. I've removed this task:\n"
                + task.toString() + "\n"
                + "Now you have " + size + " tasks in the list.";
    }

    /**
     * Shows the list of tasks.
     * @param tasks The list of tasks.
     * @return The string of the list of tasks.
     */
    public String showTasks(TaskList tasks) {
        assert tasks != null : "Task list should not be null";
        StringBuilder sb = new StringBuilder();
        if (tasks.getNumTasks() == 0) {
            sb.append("You have no tasks in your list. Slay!\n");
        } else {
            sb.append("Here are the tasks in your list:\n");
            for (int i = 0; i < tasks.getNumTasks(); i++) {
                sb.append((i + 1)).append(". ").append(tasks.getTasks().get(i).toString()).append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * Shows the tasks that match the keyword.
     *
     * @param tasks The list of tasks that match the keyword.
     * @return The string of the tasks that match the keyword.
     */
    public String showFoundTasks(TaskList tasks) {
        assert tasks != null : "Task list should not be null";
        StringBuilder sb = new StringBuilder();
        if (tasks.getNumTasks() == 0) {
            sb.append("No matching tasks found.\n");
        } else {
            sb.append("Here are the matching tasks in your list:\n");
            for (int i = 0; i < tasks.getNumTasks(); i++) {
                sb.append((i + 1)).append(". ").append(tasks.getTasks().get(i).toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
