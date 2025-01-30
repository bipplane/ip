package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventTask extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;
    protected DateTimeFormatter formatFrom = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    protected DateTimeFormatter formatTo = DateTimeFormatter.ofPattern("d MMM yyyy HH:mm");

    public EventTask(String taskName, String from, String to) {
        super(taskName);
        this.from = LocalDateTime.parse(from, formatFrom);
        this.to = LocalDateTime.parse(to, formatFrom);
    }

    public EventTask(String taskName, String from, String to, boolean isDone) {
        super(taskName, isDone);
        this.from = LocalDateTime.parse(from, formatFrom);
        this.to = LocalDateTime.parse(to, formatFrom);
    }

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

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from.format(formatTo) + " to: " + to.format(formatTo) + ")";
    }
}