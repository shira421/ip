package kyro;

import kyro.tasks.*;

public class Printer {
    private static final String SINGLE_LINE = "____________________________________________________________";

    public void showLine() {
        System.out.println(SINGLE_LINE);
    }

    public void showWelcome() {
        String logo = " ____  __.                      \n"
                + "|    |/ _|___.__._______  ____  \n"
                + "|      < <   |  |\\_  __ \\/  _ \\ \n"
                + "|    |  \\ \\___  | |  | \\(  <_> )\n"
                + "|____|__ \\/ ____| |__|   \\____/ \n"
                + "        \\/\\/                     \n";
        System.out.println("Hello from\n" + logo);
        showLine();
        System.out.println(" Hello! I'm Kyro, your personal assistant.");
        System.out.println(" What can Kyro do for you?");
        showLine();
    }

    public void showBye() {
        showLine();
        System.out.println(" Bye. Kyro hopes to see you again soon!");
        showLine();
    }

    public void showTasks(Task[] tasks) {
        showLine();
        if (tasks.length == 0) {
            System.out.println(" Kyro is glad that you have no tasks!");
        } else {
            for (int i = 0; i < tasks.length; i++) {
                System.out.printf(" %d. %s%n", i + 1, tasks[i]);
            }
        }
        showLine();
    }

    public void showAdded(Task task, int count) {
        showLine();
        System.out.println(" Kyro has added:\n  " + task);
        System.out.println(" Now you have " + count + " tasks in the list!");
        showLine();
    }

    public void showMark(Task task) {
        showLine();
        System.out.println(" Nice! Kyro has marked this task as done:");
        System.out.println("   " + task);
        showLine();
    }

    public void showUnmark(Task task) {
        showLine();
        System.out.println(" Ok, Kyro has marked this task as not done yet:");
        System.out.println("   " + task);
        showLine();
    }

    public void showError(String message) {
        showLine();
        System.out.println(" " + message);
        showLine();
    }
}
