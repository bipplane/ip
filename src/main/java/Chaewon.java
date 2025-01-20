import java.util.Scanner;
import java.util.ArrayList;

public class Chaewon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();

        Chaewon.printUnderscore();
        System.out.println("Hello! I'm Kim Chaewon!\n"
                + "What can I do for you?");
        Chaewon.printUnderscore();

    while (true) {
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        switch (parts[0]) {
            case "bye":
                break;
            case "list":
                Chaewon.printUnderscore();
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(i + 1 + ". " + list.get(i).toString());
                }
                Chaewon.printUnderscore();
                break;
            case "mark":
                int index = Integer.parseInt(parts[1]) - 1;
                list.get(index).markAsDone();
                Chaewon.printUnderscore();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(list.get(index).toString());
                Chaewon.printUnderscore();
                break;
            case "unmark":
                int index2 = Integer.parseInt(parts[1]) - 1;
                list.get(index2).markAsUndone();
                Chaewon.printUnderscore();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println(list.get(index2).toString());
                Chaewon.printUnderscore();
                break;
            default:
                Chaewon.printUnderscore();
                list.add(new Task(input));
                System.out.println("added: " + input);
                Chaewon.printUnderscore();
                break;
        }
        if (input.equals("bye")) {
            break;
        }
    }

        Chaewon.printUnderscore();
        System.out.println("Bye! Get an A for this mod and" +
                " I'll reunite IZ*ONE for you <3");
        Chaewon.printUnderscore();
    }
    // Method to print a line of underscores for my lazy ahh
    public static void printUnderscore() {
        System.out.println("____________________________________________________________");
    }
}
