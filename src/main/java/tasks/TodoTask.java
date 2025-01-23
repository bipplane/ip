package tasks;

// Description: A class that represents a ToDo task.
public class TodoTask extends Task {
    public TodoTask(String taskName) {
        super(taskName);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
