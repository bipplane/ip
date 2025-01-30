package commands;

import chaewon.*;
import tasks.DeadlineTask;

public class DeadlineCommand extends Command {
    private final String description;
    private final String by;

    public DeadlineCommand(String description) {
        this.description = description.split(" /by ")[0].trim();
        this.by = description.split(" /by ")[1].trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChaewonException {
        DeadlineTask newTask = new DeadlineTask(description, by);
        tasks.addTask(newTask);
        storage.saveTasks();
        ui.addedTask(newTask, tasks.getNumTasks());
    }
}
