package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeadlineTask extends Task {
    protected LocalDateTime by;
    protected DateTimeFormatter formatFrom = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    protected DateTimeFormatter formatTo = DateTimeFormatter.ofPattern("d MMM yyyy HH:mm");

    public DeadlineTask(String taskName, String by) {
        super(taskName);
        this.by = LocalDateTime.parse(by, formatFrom);
    }

    public DeadlineTask(String taskName, String by, boolean isDone) {
        super(taskName, isDone);
        this.by = LocalDateTime.parse(by, formatFrom);
    }

    public String getBy() {
        return by.format(formatTo);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(formatTo) + ")";
    }
}