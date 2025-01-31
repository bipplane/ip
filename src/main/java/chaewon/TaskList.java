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

    /**
     * Finds tasks with the given keyword.
     *
     * @param keyword The keyword to search for.
     */
    public ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> foundTasksList = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTaskName().toLowerCase().contains(keyword.toLowerCase())
                    || (keyword.equalsIgnoreCase("event") && task instanceof EventTask)
                    || (keyword.equalsIgnoreCase("deadline") && task instanceof DeadlineTask)
                    || (keyword.equalsIgnoreCase("todo") && task instanceof TodoTask)) {
                foundTasksList.add(task);
            }
        }
        return foundTasksList;
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