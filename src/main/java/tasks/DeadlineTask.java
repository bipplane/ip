// src/main/java/tasks/DeadlineTask.java
package tasks;

public class DeadlineTask extends Task {
    protected String by;

    public DeadlineTask(String taskName, String by) {
        super(taskName);
        this.by = by;
    }

    public DeadlineTask(String taskName, String by, boolean isDone) {
        super(taskName, isDone);
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}