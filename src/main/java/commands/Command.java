package commands;

import chaewon.ChaewonException;
import chaewon.Storage;
import chaewon.TaskList;
import chaewon.Ui;

/**
 * Represents a command that is executed by the user.
 */
public abstract class Command {

    /**
     * Executes the command.
     *
     * @param tasks   The list of tasks.
     * @param ui      The user interface.
     * @param storage The storage object.
     * @throws ChaewonException If an error occurs during execution.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws ChaewonException;
}
