package tasks;

/**
 * Represents a todo task.
 */
public class TodoTask extends Task {

    /**
     * Constructor for TodoTask.
     *
     * @param taskName Name of the task.
     */
    public TodoTask(String taskName) {
        super(taskName);
    }

    /**
     * Constructor for TodoTask.
     *
     * @param taskName Name of the task.
     * @param isDone Status of the task.
     */
    public TodoTask(String taskName, boolean isDone) {
        super(taskName, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
