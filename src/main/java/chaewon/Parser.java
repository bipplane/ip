package chaewon;

import commands.Command;
import commands.DeadlineCommand;
import commands.DeleteCommand;
import commands.ErrorCommand;
import commands.EventCommand;
import commands.ExitCommand;
import commands.FindCommand;
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
        Command c;

        try {
            switch (command) {
            case "find", "search":
                if (parts.length < 2) {
                    throw new ChaewonException("The keyword to search for cannot be empty.");
                }
                c = new FindCommand(input.split("find ")[1]);
                break;
            case "hello", "hi", "hey", "yo", "sup":
                c = new HelloCommand();
                break;
            case "bye", "goodbye", "exit", "quit", "cya":
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
            case "list", "show", "tasks":
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
            return new ErrorCommand(e.getMessage());
        }
        return c;
    }
}
