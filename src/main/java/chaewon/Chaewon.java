package chaewon;

import tasks.*;
import commands.*;

import java.util.Scanner;
import java.util.ArrayList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Represents the Chaewon chatbot.
 */
public class Chaewon {
    private final Scanner scanner = new Scanner(System.in);
    private final Ui ui = new Ui();
    private final TaskList taskList = new TaskList();
    private final Storage storage = new Storage("tasks.txt");
    private final Parser parser = new Parser();
    private boolean isExit = false;

    public static void main(String[] args) {
        Chaewon chaewon = new Chaewon();
        chaewon.run();
    }

    public Chaewon() {
        try {
            storage.loadTasks();
        } catch (FileNotFoundException e) {
            File file = new File("tasks.txt");
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