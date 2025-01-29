package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventTask extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy HHmm");

    public EventTask(String taskName, String from, String to) {
        super(taskName);
        this.from = LocalDateTime.parse(from, formatter);
        this.to = LocalDateTime.parse(to, formatter);
    }

    public EventTask(String taskName, String from, String to, boolean isDone) {
        super(taskName, isDone);
        this.from = LocalDateTime.parse(from, formatter);
        this.to = LocalDateTime.parse(to, formatter);
    }

    public String getFrom() {
        return from.format(formatter);
    }

    public String getTo() {
        return from.format(formatter);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}