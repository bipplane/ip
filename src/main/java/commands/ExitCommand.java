package commands;

import chaewon.ChaewonException;
import chaewon.Storage;
import chaewon.TaskList;
import chaewon.Ui;

/**
 * Represents a command to exit the program.
 */
public class ExitCommand extends Command {

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws ChaewonException {
        storage.saveTasks();
        return ui.goodbye();
    }
}
