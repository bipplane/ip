package commands;

import chaewon.*;
import tasks.*;

public class DeleteCommand extends Command {
    private final int taskIndex;

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
