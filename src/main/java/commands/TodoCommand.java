package commands;

import chaewon.*;
import tasks.TodoTask;

public class TodoCommand extends Command {
    private final String description;

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
