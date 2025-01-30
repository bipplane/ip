package chaewon;

import tasks.*;

public class Ui {

    /**
     * Prints a welcome message to the console.
     */
    public void welcome() {
        System.out.println("Hello! I'm Kim Chaewon!");
        System.out.println("What can I do for you?");
    }

    public void hello() {
        System.out.println("Hello! I'm Chaewon, " +
                "leader of South Korean girl group Le Sserafim!");
    }

    /**
     * Prints a goodbye message to the console.
     */
    public void goodbye() {
        System.out.println("Bye! Get an A for this mod and "
                + "I'll reunite IZ*ONE for you <3");
    }

    /**
     * Prints a message to the console.
     *
     * @param message The message to be printed.
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    public <T extends Task> void markedTask(T task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task.toString());
    }

    public <T extends Task> void unmarkedTask(T task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(task.toString());
    }

    public <T extends Task> void addedTask(T task, int size) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task.toString());
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public <T extends Task> void deletedTask(T task, int size) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(task.toString());
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public void showTasks(TaskList tasks) {
        if (tasks.getNumTasks() == 0) {
            System.out.println("You have no tasks in your list. Slay!");
            return;
        }
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.getNumTasks(); i++) {
            System.out.println((i + 1) + ". " + tasks.getTasks().get(i).toString());
        }
    }
}
