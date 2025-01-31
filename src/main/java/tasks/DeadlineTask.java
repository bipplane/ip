package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline task.
 */
public class DeadlineTask extends Task {
    protected LocalDateTime by;
    protected DateTimeFormatter formatFrom = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    protected DateTimeFormatter formatTo = DateTimeFormatter.ofPattern("d MMM yyyy HH:mm");

    /**
     * Constructor for DeadlineTask.
     *
     * @param taskName Name of the task.
     * @param by Deadline of the task.
     */
    public DeadlineTask(String taskName, String by) {
        super(taskName);
        this.by = LocalDateTime.parse(by, formatFrom);
    }

    /**
     * Constructor for DeadlineTask.
     *
     * @param taskName Name of the task.
     * @param by Deadline of the task.
     * @param isDone Status of the task.
     */
    public DeadlineTask(String taskName, String by, boolean isDone) {
        super(taskName, isDone);
        this.by = LocalDateTime.parse(by, formatFrom);
    }

    /**
     * Constructor for DeadlineTask.
     *
     * @param taskName Name of the task.
     * @param by Deadline of the task.
     * @param isDone Status of the task.
     */
    public DeadlineTask(String taskName, LocalDateTime by, boolean isDone) {
        super(taskName, isDone);
        this.by = by;
    }

    public String getBy() {
        return by.format(formatTo);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(formatTo) + ")";
    }
}
