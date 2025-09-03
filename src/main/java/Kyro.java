import java.util.Scanner;

public class Kyro {

    private static final String SINGLE_LINE = "____________________________________________________________";
    private static final int MAX_TASKS = 100;

    public static void printWelcome() {
        String logo = " ____  __.                      \n"
                + "|    |/ _|___.__._______  ____  \n"
                + "|      < <   |  |\\_  __ \\/  _ \\ \n"
                + "|    |  \\ \\___  | |  | \\(  <_> )\n"
                + "|____|__ \\/ ____| |__|   \\____/ \n"
                + "        \\/\\/                     \n";

        System.out.println("Hello from\n" + logo);

        System.out.println(SINGLE_LINE);
        System.out.println(" Hello! I'm Kyro, your personal assistant.");
        System.out.println(" What can Kyro do for you?");
        System.out.println(SINGLE_LINE);
    }

    public static void printBye() {
        System.out.println(SINGLE_LINE);
        System.out.println(" Bye. Kyro hopes to see you again soon!");
        System.out.println(SINGLE_LINE);
    }

    public static void printTasks(Task[] tasks, int count) {
        System.out.println(SINGLE_LINE);
        if (count == 0) {
            System.out.println(" Kyro is glad that you have no tasks!");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.printf(" %d. %s%n", i + 1, tasks[i].toString());
            }
        }
        System.out.println(SINGLE_LINE);
    }

    public static void printAddedTask(Task[] tasks, int count) {
        System.out.println(SINGLE_LINE);
        System.out.println(" Kyro has added:\n"
                + "  " + tasks[count].toString() + "\n"
                + " Now you have " + (count + 1) + " tasks in the list!");
        System.out.println(SINGLE_LINE);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task[] tasks = new Task[MAX_TASKS];
        int taskCount = 0;

        printWelcome();

        while (true) {
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();

            switch (command) {
            case "bye":
                printBye();
                scanner.close();
                return;

            case "list":
                printTasks(tasks, taskCount);
                break;

            case "mark":
                int markIndex = Integer.parseInt(parts[1]) - 1;
                tasks[markIndex].setDone(true);
                System.out.println(SINGLE_LINE);
                System.out.println(" Nice! Kyro has marked this task as done:");
                System.out.println("   " + tasks[markIndex].toString());
                System.out.println(SINGLE_LINE);
                break;

            case "unmark":
                int unmarkIndex = Integer.parseInt(parts[1]) - 1;
                tasks[unmarkIndex].setDone(false);
                System.out.println(SINGLE_LINE);
                System.out.println(" Ok, Kyro has marked this task as not done yet:");
                System.out.println("   " + tasks[unmarkIndex].toString());
                System.out.println(SINGLE_LINE);
                break;

            case "todo":
                tasks[taskCount] = new Todo(parts[1]);
                printAddedTask(tasks, taskCount);
                taskCount++;
                break;

            case "deadline":
                String[] deadlineTask = parts[1].split(" /by ", 2);
                tasks[taskCount] = new Deadline(deadlineTask[0], deadlineTask[1]);
                printAddedTask(tasks, taskCount);
                taskCount++;
                break;

            case "event":
                String[] eventTask = parts[1].split(" /from | /to ", 3);
                tasks[taskCount] = new Event(eventTask[0], eventTask[1], eventTask[2]);
                printAddedTask(tasks, taskCount);
                taskCount++;
                break;

            default:
                break;
            }
        }
    }
}
