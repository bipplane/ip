// src/main/java/tasks/EventTask.java
package tasks;

public class EventTask extends Task {
    protected String from;
    protected String to;

    public EventTask(String taskName, String from, String to) {
        super(taskName);
        this.from = from;
        this.to = to;
    }

    public EventTask(String taskName, String from, String to, boolean isDone) {
        super(taskName, isDone);
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}