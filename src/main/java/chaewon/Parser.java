package chaewon;

import commands.*;

/**
 * Represents a parser that handles user input.
 */
public class Parser {
    protected static String command;
    protected Ui ui = new Ui();

    public Command parse(String input) {
        String[] parts = input.split(" ");
        String command = parts[0].toLowerCase();
        Command c = null;

        try {
            switch (command) {
            case "hello":
            case "hi":
                c = new HelloCommand();
                break;
            case "goodbye":
            case "bye":
                c = new ExitCommand();
                break;
            case "todo":
                c = new TodoCommand(input.split("todo ")[1]);
                break;
            case "deadline":
                c = new DeadlineCommand(input.split("deadline ")[1]);
                break;
            case "event":
                c = new EventCommand(input.split("event ")[1]);
                break;
            case "list":
                c = new ListCommand();
                break;
            case "mark":
                c = new MarkCommand(parts.length > 1
                        ? Integer.parseInt(parts[1]) : -1);
                break;
            case "unmark":
                c = new UnmarkCommand(parts.length > 1
                        ? Integer.parseInt(parts[1]) : -1);
                break;
            case "delete":
                c = new DeleteCommand(parts.length > 1
                        ? Integer.parseInt(parts[1]) : -1);
                break;
            default:
                throw new ChaewonException("Gurl idk what you're saying..");
            }
        } catch (ChaewonException e) {
            printUnderscore();
            System.out.println("Error: " + e.getMessage());
            printUnderscore();
        }
        return c;
    }

    /**
     * Prints a line of underscores to the console.
     */
    public static void printUnderscore() {
        System.out.println("____________________________________________________________");
    }

}
