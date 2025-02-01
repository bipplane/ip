package chaewon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import commands.Command;
import commands.ExitCommand;

/**
 * Represents the chaewon.Chaewon chatbot.
 */
public class Chaewon {
    private final Scanner scanner = new Scanner(System.in);
    private final Ui ui = new Ui();
    private final TaskList taskList = new TaskList();
    private final Storage storage;
    private final Parser parser = new Parser();
    private boolean isExit = false;

    /**
     * Constructor for chaewon.Chaewon.
     */
    public Chaewon() {
        this.storage = new Storage("tasks.txt", taskList);
        try {
            storage.loadTasks();
        } catch (FileNotFoundException e) {
            File file = new File("tasks.txt");
            try {
                file.createNewFile();
            } catch (Exception ex) {
                ui.printMessage("Error creating file.");
            }
        }
        ui.welcome();
    }

    /**
     * Main method for chaewon.Chaewon. (Defunct due to GUI)
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Chaewon chaewon = new Chaewon();
        chaewon.run();
    }

    /**
     * Runs the Chaewon chatbot. (Defunct due to GUI)
     */
    public void run() {
        while (!isExit) {
            String input = scanner.nextLine();
            Command c = parser.parse(input);
            try {
                if (c != null) {
                    c.execute(taskList, ui, storage);
                }
                if (c instanceof ExitCommand) {
                    isExit = true;
                }
            } catch (ChaewonException e) {
                ui.printMessage(e.getMessage());
            }
        }
    }

    public String getResponse(String input) {
        try {
            Command c = parser.parse(input);
            return c.execute(taskList, ui, storage);
        } catch (ChaewonException e) {
            return ui.printMessage(e.getMessage());
        }
    }
}
