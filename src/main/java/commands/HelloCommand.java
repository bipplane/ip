package commands;

import chaewon.Storage;
import chaewon.TaskList;
import chaewon.Ui;

/**
 * Represents a command to greet the user.
 */
public class HelloCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.hello();
    }
}
