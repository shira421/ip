package kyro;

import java.util.Scanner;

import kyro.tasks.*;
import kyro.exceptions.*;

public class Kyro {
    private static final Printer Printer = new Printer();
    private static final TaskList tasks = new TaskList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer.showWelcome();

        while (true) {
            String input = scanner.nextLine();
            try {
                Command command = Parser.parse(input);

                switch (command.getType()) {
                case BYE:
                    Printer.showBye();
                    return;

                case LIST:
                    Printer.showTasks(tasks.getAll());
                    break;

                case MARK:
                    int markIndex = Integer.parseInt(command.getArguments()) - 1;
                    Task markTask = tasks.get(markIndex);
                    markTask.setDone(true);
                    Printer.showMark(markTask);
                    break;

                case UNMARK:
                    int unmarkIndex = Integer.parseInt(command.getArguments()) - 1;
                    Task unmarkTask = tasks.get(unmarkIndex);
                    unmarkTask.setDone(false);
                    Printer.showUnmark(unmarkTask);
                    break;

                case TODO:
                    Task todo = new Todo(command.getArguments().trim());
                    tasks.add(todo);  // may throw TaskLimitException
                    Printer.showAdded(todo, tasks.size());
                    break;

                case DEADLINE:
                    String[] deadlineParts = command.getArguments().split(" /by ", 2);
                    Task deadline = new Deadline(deadlineParts[0].trim(), deadlineParts[1].trim());
                    tasks.add(deadline);
                    Printer.showAdded(deadline, tasks.size());
                    break;

                case EVENT:
                    String[] eventParts = command.getArguments().split(" /from | /to ", 3);
                    Task event = new Event(eventParts[0].trim(), eventParts[1].trim(), eventParts[2].trim());
                    tasks.add(event);
                    Printer.showAdded(event, tasks.size());
                    break;
                }
            } catch (KyroException e) {
                Printer.showError(e.getMessage());
            } catch (NumberFormatException e) {
                Printer.showError("Kyro thinks you need to go back to school to learn what numbers are...");
            }
        }
    }
}
