import java.util.Scanner;
import java.util.ArrayList;

public class Chaewon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        Chaewon.printUnderscore();
        System.out.println("Hello! I'm Kim Chaewon!\n"
                + "What can I do for you?");
        Chaewon.printUnderscore();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                break;
            } else if (input.equals("list")) {
                Chaewon.printUnderscore();
                for (int i = 0; i != list.size(); i++) {
                    System.out.println(i + 1 + ". " + list.get(i));
                }
                Chaewon.printUnderscore();
            } else {
                Chaewon.printUnderscore();
                list.add(input);
                System.out.println("added: " + input);
                Chaewon.printUnderscore();
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
