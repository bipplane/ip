package commands;

import chaewon.Storage;
import chaewon.TaskList;
import chaewon.Ui;

/**
 * Represents a command to list all tasks.
 */
public class ListCommand extends Command {

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return ui.showTasks(tasks);
    }
}
