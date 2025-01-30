package commands;

import chaewon.*;
import tasks.*;

public class MarkCommand extends Command {
    private final int taskIndex;

    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChaewonException {
        Task task = tasks.markTaskAsDone(taskIndex);
        storage.saveTasks();
        ui.markedTask(task);
    }
}
