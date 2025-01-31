package commands;

import chaewon.ChaewonException;
import chaewon.Storage;
import chaewon.TaskList;
import chaewon.Ui;
import tasks.Task;

/**
 * Represents a command to delete a task.
 */
public class DeleteCommand extends Command {
    private final int taskIndex;

    /**
     * Constructor for DeleteCommand.
     *
     * @param taskIndex The index of the task to delete.
     */
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChaewonException {
        Task removedTask = tasks.removeTask(taskIndex);
        ui.deletedTask(removedTask, tasks.getNumTasks());
        storage.saveTasks();
    }
}
