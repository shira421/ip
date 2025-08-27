import java.util.Scanner;

public class Kyro {

    private static final String LINE = "____________________________________________________________";

    public static void main(String[] args) {
        String logo = " ____  __.                      \n"
                + "|    |/ _|___.__._______  ____  \n"
                + "|      < <   |  |\\_  __ \\/  _ \\ \n"
                + "|    |  \\ \\___  | |  | \\(  <_> )\n"
                + "|____|__ \\/ ____| |__|   \\____/ \n"
                + "        \\/\\/                     \n";

        System.out.println("Hello from\n" + logo);

        System.out.println(LINE);
        System.out.println(" Hello! I'm Kyro, your personal assistant");
        System.out.println(" What can I do for you?");
        System.out.println(LINE);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String userInput = scanner.nextLine();

            if (userInput.equals("bye")) {
                System.out.println(LINE);
                System.out.println(" Bye. Hope to see you again soon!");
                System.out.println(LINE);
                break;
            }

            System.out.println(LINE);
            System.out.println(" " + userInput);
            System.out.println(LINE);
        }

        scanner.close();
    }
}
