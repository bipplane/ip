package commands;

import chaewon.*;

public class HelloCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.hello();
    }
}
