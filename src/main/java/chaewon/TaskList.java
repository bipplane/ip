package chaewon;

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

    public int getNumTasks() {
        return tasks.size();
    }

    public Task markTaskAsDone(int index) throws ChaewonException {
        if (index < 0 || index >= tasks.size()) {
            throw new ChaewonException("Invalid task number. Please try again.");
        } else {
            Task task = tasks.get(index);
            task.markAsDone();
            return task;
        }
    }

    public Task unmarkTaskAsDone(int index) throws ChaewonException {
        if (index < 0 || index >= tasks.size()) {
            throw new ChaewonException("Invalid task number. Please try again.");
        } else {
            Task task = tasks.get(index);
            task.markAsUndone();
            return task;
        }
    }

    public <T extends Task> T addTask(T task) throws ChaewonException {
        if (task == null) {
            throw new ChaewonException("Gurl what? Task cannot be null.");
        } else {
            tasks.add(task);
            return task;
        }
    }

    public Task removeTask(int index) throws ChaewonException {
        if (index < 0 || index >= tasks.size()) {
            throw new ChaewonException("Invalid task number. Please try again.");
        } else {
            return tasks.remove(index);
        }
    }
}