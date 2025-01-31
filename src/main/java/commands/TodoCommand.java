package commands;

import chaewon.ChaewonException;
import chaewon.Storage;
import chaewon.TaskList;
import chaewon.Ui;
import tasks.TodoTask;

/**
 * Represents a command to add a todo task.
 */
public class TodoCommand extends Command {
    private final String description;

    /**
     * Constructor for TodoCommand.
     *
     * @param description The description of the todo task.
     */
    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChaewonException {
        TodoTask newTask = tasks.addTask(new TodoTask(description));
        storage.saveTasks();
        ui.addedTask(newTask, tasks.getNumTasks());
    }
}
