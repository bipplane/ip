package tasks;

// Description: A class that represents an event task.
public class EventTask extends Task {
    protected String from;
    protected String to;
    public EventTask(String taskName, String from, String to) {
        super(taskName);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
