package chaewon;

import commands.*;

import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Represents the Chaewon chatbot.
 */
public class Chaewon {
    private final Scanner scanner = new Scanner(System.in);
    private final Ui ui = new Ui();
    private final TaskList taskList = new TaskList();
    private final Storage storage;
    private final Parser parser = new Parser();
    private boolean isExit = false;

    public static void main(String[] args) {
        Chaewon chaewon = new Chaewon();
        chaewon.run();
    }

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
}