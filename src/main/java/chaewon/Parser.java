package chaewon;

import commands.Command;
import commands.DeadlineCommand;
import commands.DeleteCommand;
import commands.EventCommand;
import commands.ExitCommand;
import commands.HelloCommand;
import commands.ListCommand;
import commands.MarkCommand;
import commands.TodoCommand;
import commands.UnmarkCommand;

/**
 * Represents a parser that handles user input.
 */
public class Parser {
    protected static String command;
    protected Ui ui = new Ui();

    /**
     * Parses the user input and returns the corresponding command.
     *
     * @param input The user input.
     * @return The corresponding command.
     */
    public Command parse(String input) {
        String[] parts = input.split(" ");
        String command = parts[0].toLowerCase();
        Command c = null;

        try {
            switch (command) {
            case "find", "search":
                if (parts.length < 2) {
                    throw new ChaewonException("The keyword to search for cannot be empty.");
                }
                c = new FindCommand(input.split("find ")[1]);
                break;
            case "hello", "hi":
                c = new HelloCommand();
                break;
            case "bye", "goodbye", "exit":
                c = new ExitCommand();
                break;
            case "todo", "task":
                if (parts.length < 2) {
                    throw new ChaewonException("The description of a todo cannot be empty.");
                }
                c = new TodoCommand(input.split("todo ")[1]);
                break;
            case "deadline":
                if (parts.length < 2) {
                    throw new ChaewonException("The description of a deadline cannot be empty.");
                }
                c = new DeadlineCommand(input.split("deadline ")[1]);
                break;
            case "event":
                if (parts.length < 2) {
                    throw new ChaewonException("The description of an event cannot be empty.");
                }
                c = new EventCommand(input.split("event ")[1]);
                break;
            case "list", "show":
                c = new ListCommand();
                break;
            case "mark", "check":
                c = new MarkCommand(parts.length > 1
                        ? Integer.parseInt(parts[1]) - 1 : -1);
                break;
            case "unmark", "uncheck":
                c = new UnmarkCommand(parts.length > 1
                        ? Integer.parseInt(parts[1]) - 1 : -1);
                break;
            case "delete", "remove":
                c = new DeleteCommand(parts.length > 1
                        ? Integer.parseInt(parts[1]) - 1 : -1);
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
