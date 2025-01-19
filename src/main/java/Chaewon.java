import java.util.Scanner;

public class Chaewon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Chaewon.printUnderscore();
        System.out.println("Hello! I'm Kim Chaewon!\n"
                + "What can I do for you?");
        Chaewon.printUnderscore();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                break;
            } else {
                Chaewon.printUnderscore();
                System.out.println(input);
                Chaewon.printUnderscore();
            }
        }

        Chaewon.printUnderscore();
        System.out.println("Get an A for this mod and" +
                " I'll reunite IZ*ONE for you <3");
        Chaewon.printUnderscore();
    }
    // Method to print a line of underscores for my lazy ahh
    public static void printUnderscore() {
        System.out.println("____________________________________________________________");
    }
}
