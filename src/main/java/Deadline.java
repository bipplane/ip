// Description: A class that represents a deadline task.
public class Deadline extends Task {
    protected String by;
    public Deadline(String taskName, String by) {
        super(taskName);
        this.by = by;
    }
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
