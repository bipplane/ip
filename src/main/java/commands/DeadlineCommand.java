package commands;

import chaewon.ChaewonException;
import chaewon.Storage;
import chaewon.TaskList;
import chaewon.Ui;
import tasks.DeadlineTask;

/**
 * Represents a command to add a deadline task.
 */
public class DeadlineCommand extends Command {
    private final String description;
    private final String by;

    /**
     * Constructor for DeadlineCommand.
     *
     * @param description The description of the deadline task.
     */
    public DeadlineCommand(String description) {
        assert description.contains(" /by ") : "Deadline command should contain /by";
        this.description = description.split(" /by ")[0].trim();
        this.by = description.split(" /by ")[1].trim();
        assert !this.description.isBlank() : "Deadline command should contain a description";
        assert !this.by.isBlank() : "Deadline command should contain a by";
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws ChaewonException {
        DeadlineTask newTask = new DeadlineTask(description, by);
        tasks.addTask(newTask);
        storage.saveTasks();
        return ui.addedTask(newTask, tasks.getNumTasks());
    }
}
