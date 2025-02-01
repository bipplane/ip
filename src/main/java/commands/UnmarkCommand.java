package commands;

import chaewon.ChaewonException;
import chaewon.Storage;
import chaewon.TaskList;
import chaewon.Ui;
import tasks.Task;

/**
 * Represents a command to unmark a task as done.
 */
public class UnmarkCommand extends Command {
    private final int taskIndex;

    /**
     * Constructor for UnmarkCommand.
     *
     * @param taskIndex The index of the task to unmark as done.
     */
    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws ChaewonException {
        Task task = tasks.unmarkTaskAsDone(taskIndex);
        storage.saveTasks();
        return ui.unmarkedTask(task);
    }
}
