package commands;

import java.util.ArrayList;

import chaewon.ChaewonException;
import chaewon.Storage;
import chaewon.TaskList;
import chaewon.Ui;
import tasks.Task;

/**
 * Represents a command to find tasks with matching keywords.
 */
public class FindCommand extends Command {
    private final String keyword;

    /**
     * Constructor for FindCommand.
     *
     * @param keyword The keyword to search for.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword.toLowerCase();
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws ChaewonException {
        ArrayList<Task> foundTasksList = taskList.findTasks(keyword);
        return ui.showFoundTasks(new TaskList(foundTasksList));
    }
}
