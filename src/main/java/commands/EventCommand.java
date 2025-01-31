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
        this.description = description.split(" /")[0].trim();
        this.from = description.split(" /")[1].split("from ")[1].trim();
        this.to = description.split(" /")[2].split("to ")[1].trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChaewonException {
        EventTask newTask = new EventTask(description, from, to);
        tasks.addTask(newTask);
        storage.saveTasks();
        ui.addedTask(newTask, tasks.getNumTasks());

    }
}
