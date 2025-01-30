package commands;

import chaewon.*;
import tasks.*;

public class UnmarkCommand extends Command {
    private final int taskIndex;

    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChaewonException {
        Task task = tasks.unmarkTaskAsDone(taskIndex);
        storage.saveTasks();
        ui.unmarkedTask(task);
    }
}
