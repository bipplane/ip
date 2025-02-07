package commands;

import chaewon.ChaewonException;
import chaewon.Storage;
import chaewon.TaskList;
import chaewon.Ui;
import tasks.EventTask;

/**
 * Represents a command to add an event task.
 */
public class EventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;

    /**
     * Constructor for EventCommand.
     *
     * @param description The description of the event task.
     */
    public EventCommand(String description) {
        assert description.contains(" /from ") : "Event command should contain /from";
        assert description.contains(" /to ") : "Event command should contain /to";
        this.description = description.split(" /")[0].trim();
        assert !this.description.isBlank() : "Event command should contain a description";
        this.from = description.split(" /")[1].split("from ")[1].trim();
        assert !this.from.isBlank() : "Event command should contain a from";
        this.to = description.split(" /")[2].split("to ")[1].trim();
        assert !this.to.isBlank() : "Event command should contain a to";
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws ChaewonException {
        EventTask newTask = new EventTask(description, from, to);
        tasks.addTask(newTask);
        storage.saveTasks();
        return ui.addedTask(newTask, tasks.getNumTasks());
    }
}
