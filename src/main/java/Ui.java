import java.util.Scanner;

public class Ui {
    private final Scanner scanner = new Scanner(System.in);

    public Ui() {
    }

    /**
     * Prints a line of underscores to the console.
     */
    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Prints a welcome message to the console.
     */
    public static void welcome() {
        printLine();
        System.out.println("Hello! I'm Kim Chaewon!");
        System.out.println("What can I do for you?");
        printLine();
    }

    /**
     * Prints a goodbye message to the console.
     */
    public static void goodbye() {
        printLine();
        System.out.println("Bye! Get an A for this mod and "
                + "I'll reunite IZ*ONE for you <3");
        printLine();
    }

    /**
     * Prints a message to the console.
     *
     * @param message The message to be printed.
     */
    public static void printMessage(String message) {
        printLine();
        System.out.println(message);
        printLine();
    }
}
