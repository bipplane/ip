import tasks.*;

import java.util.ArrayList;

/**
 * Represents a list of tasks.
 */
public class TaskList {
    protected ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void markTaskAsDone(int index) throws ChaewonException {
        if (index < 0 || index >= tasks.size()) {
            throw new ChaewonException("Invalid task number. Please try again.");
        } else {
            tasks.get(index).markAsDone();
            Ui.markTask(tasks.get(index));
        }
    }

    public void unmarkTaskAsDone(int index) throws ChaewonException {
        if (index < 0 || index >= tasks.size()) {
            throw new ChaewonException("Invalid task number. Please try again.");
        } else {
            tasks.get(index).markAsUndone();
            Ui.unmarkTask(tasks.get(index));
        }
    }

    public <T extends Task> void addTask(T task) throws ChaewonException {
        if (task == null) {
            throw new ChaewonException("Gurl what? Task cannot be null.");
        } else {
            tasks.add(task);
            Ui.addTask(task, tasks.size());
        }
    }

    public void deleteTask(int index) throws ChaewonException {
        if (index < 0 || index >= tasks.size()) {
            throw new ChaewonException("Invalid task number. Please try again.");
        } else {
            Task task = tasks.remove(index);
            Ui.deleteTask(task, tasks.size());
        }
    }

}
