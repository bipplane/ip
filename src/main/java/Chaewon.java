import tasks.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Represents the Chaewon chatbot.
 */
public class Chaewon {
    private final Scanner scanner;
    private final ArrayList<Task> list;

    public static void main(String[] args) {
        Chaewon chaewon = new Chaewon();
        chaewon.run();
    }

    public Chaewon() {
        scanner = new Scanner(System.in);
        list = new ArrayList<>();
        printUnderscore();
        System.out.println("Hello! I'm Kim Chaewon!\n"
                + "What can I do for you?");
        printUnderscore();
    }

    public void run() {
        while (true) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            StringBuilder stringBuilder = new StringBuilder();

            if (parts.length > 1 && (parts[0].equals("todo") || parts[0].equals("deadline")
                    || parts[0].equals("event"))) {

                for (int i = 1; i < parts.length; i++) {
                    String part = parts[i] + " ";
                    stringBuilder.append(part);
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            try {
                switch (parts[0]) {
                    case "bye":
                        handleBye();
                        return;
                    case "todo":
                        handleTodo(parts, stringBuilder);
                        break;
                    case "deadline":
                        handleDeadline(stringBuilder);
                        break;
                    case "event":
                        handleEvent(stringBuilder);
                        break;
                    case "list":
                        handleList();
                        break;
                    case "mark":
                        handleMark(parts);
                        break;
                    case "unmark":
                        handleUnmark(parts);
                        break;
                    case "delete":
                        handleDelete(parts);
                        break;
                    default:
                        handleUnknownCommand(parts);
                }
            } catch (ChaewonException e) {
                printUnderscore();
                System.out.println("Error: " + e.getMessage());
                printUnderscore();
            }
        }
    }

    // Method to handle the bye command
    private void handleBye() {
        printUnderscore();
        System.out.println("Bye! Get an A for this mod and" +
                " I'll reunite IZ*ONE for you <3");
        printUnderscore();
    }

    // Method to handle the todo command
    private void handleTodo(String[] parts, StringBuilder stringBuilder) {
        if (parts.length < 2) {
            throw new IllegalArgumentException("The description of a todo cannot be empty.");
        }
        list.add(new TodoTask(stringBuilder.toString()));
        printUnderscore();
        System.out.println("Got it. I've added this task:");
        System.out.println(list.get(list.size() - 1).toString());
        System.out.println("Now you have " + list.size() + " tasks in the list.");
        printUnderscore();
    }

    // Method to handle the deadline command
    private void handleDeadline(StringBuilder stringBuilder) {
        String[] deadlineParts = stringBuilder.toString().split(" /by ");
        if (deadlineParts.length < 2) {
            throw new ChaewonException("Invalid deadline format. Use: deadline <description> /by <time>");
        }
        String description = deadlineParts[0];
        String by = deadlineParts[1];
        list.add(new DeadlineTask(description, by));
        printUnderscore();
        System.out.println("Got it. I've added this task:");
        System.out.println(list.get(list.size() - 1).toString());
        System.out.println("Now you have " + list.size() + " tasks in the list.");
        printUnderscore();
    }

    // Method to handle the event command
    private void handleEvent(StringBuilder stringBuilder) {
        String[] eventParts = stringBuilder.toString().split(" /from | /to ");
        if (eventParts.length < 3) {
            throw new ChaewonException("Invalid event format. " +
                    "Use: event <description> /from <start time> /to <end time>");
        }
        String description = eventParts[0];
        String from = eventParts[1];
        String to = eventParts[2];
        list.add(new tasks.EventTask(description, from, to));
        printUnderscore();
        System.out.println("Got it. I've added this task:");
        System.out.println(list.get(list.size() - 1).toString());
        System.out.println("Now you have " + list.size() + " tasks in the list.");
        printUnderscore();
    }

    // Method to handle the list command
    private void handleList() {
        printUnderscore();
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i).toString());
        }
        printUnderscore();
    }

    // Method to handle the mark command
    private void handleMark(String[] parts) {
        int index = Integer.parseInt(parts[1]) - 1;
        list.get(index).markAsDone();
        printUnderscore();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(list.get(index).toString());
        printUnderscore();
    }

    // Method to handle the unmark command
    private void handleUnmark(String[] parts) {
        int index = Integer.parseInt(parts[1]) - 1;
        list.get(index).markAsUndone();
        printUnderscore();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(list.get(index).toString());
        printUnderscore();
    }

    // Method to handle unknown commands
    private void handleUnknownCommand(String[] parts) {
        if (parts[0].isEmpty()) {
            throw new ChaewonException("Please enter a command.");
        }
        throw new ChaewonException("Unknown command: " + parts[0]);
    }

    // Method to handle the delete command
    private void handleDelete(String[] parts) {
        int index = Integer.parseInt(parts[1]) - 1;
        Task removedTask = list.remove(index);
        printUnderscore();
        System.out.println("Noted. I've removed this task:");
        System.out.println(removedTask.toString());
        System.out.println("Now you have " + list.size() + " tasks in the list.");
        printUnderscore();
    }

    // Method to print a line of underscores for my lazy ahh
    public static void printUnderscore() {
        System.out.println("____________________________________________________________");
    }
}