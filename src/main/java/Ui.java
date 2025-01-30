import tasks.*;

import java.util.Scanner;

public class Ui {
    private final Scanner scanner = new Scanner(System.in);

    public Ui() {
    }

    /**
     * Prints a welcome message to the console.
     */
    public static void welcome() {
        System.out.println("Hello! I'm Kim Chaewon!");
        System.out.println("What can I do for you?");
    }

    /**
     * Prints a goodbye message to the console.
     */
    public static void goodbye() {
        System.out.println("Bye! Get an A for this mod and "
                + "I'll reunite IZ*ONE for you <3");
    }

    /**
     * Prints a message to the console.
     *
     * @param message The message to be printed.
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static <T extends Task> void markTask(T task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task.toString());
    }

    public static <T extends Task> void unmarkTask(T task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(task.toString());
    }

    public static <T extends Task> void addTask(T task, int size) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task.toString());
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public static <T extends Task> void deleteTask(T task, int size) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(task.toString());
        System.out.println("Now you have " + size + " tasks in the list.");
    }
}
