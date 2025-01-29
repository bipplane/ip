import tasks.*;

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
    private final Scanner scanner;
    private final ArrayList<Task> list;

    public static void main(String[] args) {
        Chaewon chaewon = new Chaewon();
        chaewon.run();
    }

    public Chaewon() {
        scanner = new Scanner(System.in);
        list = new ArrayList<>();
        try {
            loadTasks();
        } catch (FileNotFoundException e) {
            File file = new File("tasks.txt");
        }
        printUnderscore();
        System.out.println("Hello! I'm Kim Chaewon!\n"
                + "What can I do for you?");
        printUnderscore();
    }

    public void run() {
        while (true) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];
            StringBuilder stringBuilder = new StringBuilder();

            if (parts.length > 1 && (command.equals("todo") || command.equals("deadline")
                    || parts[0].equals("event"))) {

                for (int i = 1; i < parts.length; i++) {
                    String part = parts[i] + " ";
                    stringBuilder.append(part);
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            try {
                switch (command) {
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

    private void saveTasks() {
    try {
        File file = new File("tasks.txt");
        FileWriter fileWriter = new FileWriter(file);
        for (Task task : list) {
            String taskType = "";
            if (task instanceof TodoTask) {
                taskType = "T";
            } else if (task instanceof DeadlineTask) {
                taskType = "D";
            } else if (task instanceof EventTask) {
                taskType = "E";
            }
            String isDone = task.isDone() ? "1" : "0";
            String taskString = taskType + " | " + isDone + " | " + task.getTaskName();
            if (task instanceof DeadlineTask) {
                taskString += " | " + ((DeadlineTask) task).getBy();
            } else if (task instanceof EventTask) {
                taskString += " | " + ((EventTask) task).getFrom() + " | " + ((EventTask) task).getTo();
            }
            fileWriter.write(taskString + "\n");
        }
        fileWriter.close();
    } catch (IOException e) {
        System.out.println("Error saving tasks to file.");
    }
}

    private void loadTasks() throws FileNotFoundException {
        File file = new File("tasks.txt");
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String taskString = fileScanner.nextLine();
            String[] taskParts = taskString.split(" \\| ");
            String taskType = taskParts[0];
            boolean isDone = taskParts[1].equals("1");
            String taskName = taskParts[2];
            switch (taskType) {
            case "T":
                list.add(new TodoTask(taskName, isDone));
                break;
            case "D":
                String by = taskParts[3];
                list.add(new DeadlineTask(taskName, by, isDone));
                break;
            case "E":
                String from = taskParts[3];
                String to = taskParts[4];
                list.add(new EventTask(taskName, from, to, isDone));
                break;
            default:
                break;
            }
        }
    }

    /**
     * Handles the `bye` command by printing a goodbye message and exiting the program.
     */
    private void handleBye() {
        printUnderscore();
        System.out.println("Bye! Get an A for this mod and "
                + "I'll reunite IZ*ONE for you <3");
        printUnderscore();
        saveTasks();
    }

    /**
     * Handles the `todo` command by adding a new ToDo task to the list.
     *
     * @param parts          The parts of the input command split by spaces.
     * @param stringBuilder  The StringBuilder containing the task description.
     * @throws ChaewonException if the description of the todo is empty.
     */
    private void handleTodo(String[] parts, StringBuilder stringBuilder) {
        if (parts.length < 2) {
            throw new ChaewonException("The description of a todo cannot be empty.");
        }
        list.add(new TodoTask(stringBuilder.toString()));
        printUnderscore();
        System.out.println("Got it. I've added this task:");
        System.out.println(list.get(list.size() - 1).toString());
        System.out.println("Now you have " + list.size() + " tasks in the list.");
        printUnderscore();
    }

    /**
     * Handles the `deadline` command by adding a new ToDo task to the list.
     *
     * @param stringBuilder     The StringBuilder containing the task description.
     * @throws ChaewonException if the deadline format is invalid.
     */
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

    /**
     *
     * Handles the `event` command by adding a new Event task to the list.
     * @param stringBuilder     The StringBuilder containing the task description.
     * @throws ChaewonException if the event format is invalid.
     */
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

    /**
     * Handles the `list` command by printing out all the tasks in the list.
     */
    private void handleList()
    {
        printUnderscore();
        if (list.isEmpty()) {
            System.out.println("You have no tasks in the list.");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + 1 + ". " + list.get(i).toString());
            }
        }
        printUnderscore();
    }

    /**
     * Handles the `mark` command by marking a task as done.
     *
     * @param parts             The parts of the input command split by spaces.
     * @throws ChaewonException if the index of the task to mark is invalid.
     */
    private void handleMark(String[] parts) {
        printUnderscore();
        if (parts.length < 2) {
            throw new ChaewonException("Please enter the task number to mark.");
        }
        int index = Integer.parseInt(parts[1]) - 1;
        if (index < 0 || index >= list.size()) {
            throw new ChaewonException("Invalid task number.");
        } else {
            list.get(index).markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(list.get(index).toString());
        }
        printUnderscore();
    }

    /**
     * Handles the `unmark` command by marking a task as not done.
     *
     * @param parts            The parts of the input command split by spaces.
     * @throws ChaewonException if the index of the task to unmark is invalid.
     */
    private void handleUnmark(String[] parts) {
        printUnderscore();
        if (parts.length < 2) {
            throw new ChaewonException("Please enter the task number to unmark.");
        }
        int index = Integer.parseInt(parts[1]) - 1;
        if (index < 0 || index >= list.size()) {
            throw new ChaewonException("Invalid task number.");
        } else {
            list.get(index).markAsUndone();
            System.out.println("OK, I've marked this task as not done yet:");
            System.out.println(list.get(index).toString());
        }
        printUnderscore();
    }

    /**
     * Handles an unknown command by throwing a ChaewonException.
     *
     * @param parts            The parts of the input command split by spaces.
     * @throws ChaewonException if the command is empty or unknown.
     */
    private void handleUnknownCommand(String[] parts) {
        if (parts[0].isEmpty()) {
            throw new ChaewonException("Please enter a command.");
        }
        throw new ChaewonException("Unknown command: " + parts[0]);
    }

    /**
     * Handles the `delete` command by deleting a task from the list.
     *
     * @param parts            The parts of the input command split by spaces.
     */
    private void handleDelete(String[] parts) {
        printUnderscore();
        if (parts.length < 2) {
            throw new ChaewonException("Please enter the task number to delete.");
        }
        int index = Integer.parseInt(parts[1]) - 1;
        if (index < 0 || index >= list.size()) {
            throw new ChaewonException("Invalid task number.");
        } else {
            Task removedTask = list.remove(index);
            System.out.println("Noted. I've removed this task:");
            System.out.println(removedTask.toString());
            System.out.println("Now you have " + list.size() + " tasks in the list.");
        }
        printUnderscore();
    }

    /**
     * Prints a line of underscores to the console.
     */
    public static void printUnderscore() {
        System.out.println("____________________________________________________________");
    }
}