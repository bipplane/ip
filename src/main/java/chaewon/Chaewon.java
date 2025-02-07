package chaewon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import commands.Command;
import commands.ExitCommand;

/**
 * Represents the Chaewon chatbot.
 */
public class Chaewon {
    private final Scanner scanner;
    private final Ui ui;
    private final TaskList taskList;
    private final Storage storage;
    private final Parser parser;
    private boolean isExit = false;

    /**
     * Constructor for Chaewon.
     */
    public Chaewon() {
        String filePath = "tasks.txt";
        this.scanner = new Scanner(System.in);
        this.ui = new Ui();
        this.taskList = new TaskList();
        this.storage = new Storage(filePath, taskList);
        this.parser = new Parser();
        try {
            storage.loadTasks();
        } catch (FileNotFoundException e) {
            File file = new File(filePath);
            try {
                file.createNewFile();
            } catch (Exception ex) {
                ui.printMessage("Error creating file.");
            }
        }
        ui.welcome();
    }

    /**
     * gui.Main method for Chaewon. (Defunct due to GUI)
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
            assert c != null : "Command should not be null";
            try {
                c.execute(taskList, ui, storage);
                if (c instanceof ExitCommand) {
                    isExit = true;
                }
            } catch (ChaewonException e) {
                ui.printMessage(e.getMessage());
            }
        }
    }

    /**
     * Gets the response from Chaewon.
     *
     * @param input The user input.
     * @return The response from Chaewon.
     */
    public String getResponse(String input) {
        try {
            Command c = parser.parse(input);
            assert c != null : "Command should not be null";
            String response = c.execute(taskList, ui, storage);
            if (c instanceof ExitCommand) {
                isExit = true;
            }
            return response;
        } catch (ChaewonException e) {
            return ui.printMessage(e.getMessage());
        }
    }

    public boolean isExit() {
        return isExit;
    }
}
