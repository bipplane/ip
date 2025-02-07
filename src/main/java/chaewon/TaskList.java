package chaewon;

import java.util.ArrayList;
import java.util.stream.Collectors;

import tasks.DeadlineTask;
import tasks.EventTask;
import tasks.Task;
import tasks.TodoTask;

/**
 * Represents a list of tasks.
 */
public class TaskList {
    protected ArrayList<Task> tasks;

    /**
     * Constructor for empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructor for TaskList with tasks.
     *
     * @param tasks The list of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        assert tasks != null : "Tasks should not be null";
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
        assert keyword != null && !keyword.isEmpty() : "Keyword should not be null or empty";
    }

    public int getNumTasks() {
        return tasks.size();
    }

    /**
     * Marks a task as done.
     *
     * @param index The index of the task to be marked as done.
     * @return The task that was marked as done.
     * @throws ChaewonException If the index is invalid.
     */
    public Task markTaskAsDone(int index) throws ChaewonException {
        if (index < 0 || index >= tasks.size()) {
            throw new ChaewonException("Invalid task number. Please try again.");
        } else {
            Task task = tasks.get(index);
            task.markAsDone();
            return task;
        }
    }

    /**
     * Marks a task as not done.
     *
     * @param index The index of the task to be marked as not done.
     * @return The task that was marked as not done.
     * @throws ChaewonException If the index is invalid.
     */
    public Task unmarkTaskAsDone(int index) throws ChaewonException {
        if (index < 0 || index >= tasks.size()) {
            throw new ChaewonException("Invalid task number. Please try again.");
        } else {
            Task task = tasks.get(index);
            task.markAsUndone();
            return task;
        }
    }

    /**
     * Adds a task to the list of tasks.
     *
     * @param task The task to be added.
     * @return The task that was added.
     * @throws ChaewonException If the task is null.
     */
    public <T extends Task> T addTask(T task) throws ChaewonException {
        if (task == null) {
            throw new ChaewonException("Gurl what? Task cannot be null.");
        } else {
            tasks.add(task);
            return task;
        }
    }

    /**
     * Removes a task from the list of tasks.
     *
     * @param index The index of the task to be removed.
     * @return The task that was removed.
     * @throws ChaewonException If the index is invalid.
     */
    public Task removeTask(int index) throws ChaewonException {
        if (index < 0 || index >= tasks.size()) {
            throw new ChaewonException("Invalid task number. Please try again.");
        } else {
            return tasks.remove(index);
        }
    }
}
