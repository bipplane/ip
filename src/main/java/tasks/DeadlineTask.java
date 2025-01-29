package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeadlineTask extends Task {
    protected LocalDateTime by;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy HHmm");

    public DeadlineTask(String taskName, String by) {
        super(taskName);
        this.by = LocalDateTime.parse(by, formatter);
    }

    public DeadlineTask(String taskName, String by, boolean isDone) {
        super(taskName, isDone);
        this.by = LocalDateTime.parse(by, formatter);
    }

    public String getBy() {
        return by.format(formatter);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(formatter) + ")";
    }
}