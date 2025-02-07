package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an event task.
 */
public class EventTask extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;
    protected DateTimeFormatter formatFrom = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    protected DateTimeFormatter formatTo = DateTimeFormatter.ofPattern("d MMM yyyy HH:mm");

    /**
     * Constructor for EventTask.
     *
     * @param taskName Name of the task.
     * @param from Start time of the task.
     * @param to End time of the task.
     */
    public EventTask(String taskName, String from, String to) {
        super(taskName);
        this.from = LocalDateTime.parse(from, formatFrom);
        this.to = LocalDateTime.parse(to, formatFrom);
    }

    /**
     * Constructor for EventTask.
     *
     * @param taskName Name of the task.
     * @param from Start time of the task.
     * @param to End time of the task.
     * @param isDone Status of the task.
     */
    public EventTask(String taskName, String from, String to, boolean isDone) {
        super(taskName, isDone);
        this.from = LocalDateTime.parse(from, formatFrom);
        this.to = LocalDateTime.parse(to, formatFrom);
    }

    /**
     * Constructor for EventTask.
     *
     * @param taskName Name of the task.
     * @param from Start time of the task.
     * @param to End time of the task.
     * @param isDone Status of the task.
     */
    public EventTask(String taskName, LocalDateTime from, LocalDateTime to, boolean isDone) {
        super(taskName, isDone);
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from.format(formatTo);
    }

    public String getTo() {
        return from.format(formatTo);
    }

    /**
     * Checks if the task has a conflict with another task.
     *
     * @param task The task to check for conflict.
     * @return True if there is a conflict, false otherwise.
     */
    public boolean hasConflict(EventTask task) {
        return (this.from.isBefore(task.to) && this.to.isAfter(task.from))
                || (this.from.isEqual(task.from) || this.to.isEqual(task.to));
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from.format(formatTo) + " to: " + to.format(formatTo) + ")";
    }
}
