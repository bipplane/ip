package commands;

import chaewon.*;

public class ExitCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        storage.saveTasks();
        ui.goodbye();
    }
}
