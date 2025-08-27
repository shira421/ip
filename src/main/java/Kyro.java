import java.util.Scanner;

public class Kyro {

    private static final String LINE = "____________________________________________________________";
    private static final int MAX_TASKS = 100;

    public static void printWelcome() {
        String logo = " ____  __.                      \n"
                + "|    |/ _|___.__._______  ____  \n"
                + "|      < <   |  |\\_  __ \\/  _ \\ \n"
                + "|    |  \\ \\___  | |  | \\(  <_> )\n"
                + "|____|__ \\/ ____| |__|   \\____/ \n"
                + "        \\/\\/                     \n";

        System.out.println("Hello from\n" + logo);

        System.out.println(LINE);
        System.out.println(" Hello! I'm Kyro, your personal assistant");
        System.out.println(" What can Kyro do for you?");
        System.out.println(LINE);
    }

    public static void printBye() {
        System.out.println(LINE);
        System.out.println(" Bye. Kyro hopes to see you again soon!");
        System.out.println(LINE);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tasks = new String[MAX_TASKS];
        int taskCount = 0;

        printWelcome();

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("bye")) {
                printBye();
                break;
            } else if (input.equalsIgnoreCase("list")) {
                System.out.println(LINE);
                if (taskCount == 0) {
                    System.out.println(" Kyro is glad that you have no tasks!");
                } else {
                    for (int i = 0; i < taskCount; i++) {
                        System.out.printf(" %d. %s%n", i + 1, tasks[i]);
                    }
                }
                System.out.println(LINE);
            } else if (input.isEmpty()) {
                continue;
            } else {
                tasks[taskCount++] = input;
                System.out.println(LINE);
                System.out.println(" added: " + input);
                System.out.println(LINE);
            }
        }
        scanner.close();
    }
}
