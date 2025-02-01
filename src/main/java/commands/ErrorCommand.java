package commands;

import chaewon.Storage;
import chaewon.TaskList;
import chaewon.Ui;

/**
 * Represents a command that is executed by the user.
 */
public class ErrorCommand extends Command {
    private final String errorMessage;

    public ErrorCommand(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return errorMessage;
    }
}
