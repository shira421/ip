package kyro.base;

import kyro.tasks.*;

import java.util.ArrayList;

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
        System.out.println(" Bye. Kyro hopes to see you again soon!");
    }

    public void showTasks(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println(" Kyro is glad that you have no tasks!");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.printf(" %d. %s%n", i + 1, tasks.get(i));
            }
        }
    }

    public void showAdded(Task task, int count) {
        System.out.println(" Kyro has added:\n  " + task);
        System.out.println(" Now you have " + count + " tasks in the list!");
    }

    public void showMark(Task task) {
        System.out.println(" Nice! Kyro has marked this task as done:");
        System.out.println("   " + task);
    }

    public void showUnmark(Task task) {
        System.out.println(" Ok, Kyro has marked this task as not done yet:");
        System.out.println("   " + task);
    }

    public void showDelete(Task task, int count) {
        System.out.println(" Kyro has deleted:\n  " + task);
        System.out.println(" Now you have " + count + " tasks in the list!");
    }

    public void showFind(ArrayList<Task> matchingTasks) {
        System.out.println(" Here are the matching tasks in your schedule:");
        for (int i = 0; i < matchingTasks.size(); i++) {
            System.out.printf(" %d. %s%n", i + 1, matchingTasks.get(i));
        }
    }

    public void showError(String message) {
        System.out.println(" " + message);
    }
}
