package kyro;

import kyro.tasks.*;
import kyro.exceptions.*;

public class Command {
    private final CommandList type;
    private final String arguments;

    public Command(CommandList type) {
        this(type, "");
    }

    public Command(CommandList type, String arguments) {
        this.type = type;
        this.arguments = arguments;
    }

    public boolean isExit() {
        return type == CommandList.BYE;
    }

    public void execute(TaskList tasks, Printer printer, Storage storage) throws KyroException {
        switch (type) {
        case BYE:
            printer.showBye();
            break;

        case LIST:
            printer.showTasks(tasks.getTaskList());
            break;

        case MARK:
            int markIndex = Integer.parseInt(arguments) - 1;
            Task markTask = tasks.get(markIndex);
            markTask.setDone(true);
            storage.save(tasks);
            printer.showMark(markTask);
            break;

        case UNMARK:
            int unmarkIndex = Integer.parseInt(arguments) - 1;
            Task unmarkTask = tasks.get(unmarkIndex);
            unmarkTask.setDone(false);
            storage.save(tasks);
            printer.showUnmark(unmarkTask);
            break;

        case TODO:
            if (arguments.trim().isEmpty()) {
                throw new KyroException("The description of a todo cannot be empty!");
            }
            Task todo = new Todo(arguments.trim());
            tasks.add(todo);
            storage.save(tasks);
            printer.showAdded(todo, tasks.size());
            break;

        case DEADLINE:
            String[] deadlineParts = arguments.split(" /by ", 2);
            if (deadlineParts.length < 2) {
                throw new KyroException("Deadline format must be: <desc> /by <time>");
            }
            Task deadline = new Deadline(deadlineParts[0].trim(), deadlineParts[1].trim());
            tasks.add(deadline);
            storage.save(tasks);
            printer.showAdded(deadline, tasks.size());
            break;

        case EVENT:
            String[] eventParts = arguments.split(" /from | /to ", 3);
            if (eventParts.length < 3) {
                throw new KyroException("Event format must be: <desc> /from <start> /to <end>");
            }
            Task event = new Event(eventParts[0].trim(), eventParts[1].trim(), eventParts[2].trim());
            tasks.add(event);
            storage.save(tasks);
            printer.showAdded(event, tasks.size());
            break;

        case DELETE:
            int deleteIndex = Integer.parseInt(arguments) - 1;
            Task deleteTask = tasks.get(deleteIndex);
            tasks.remove(deleteIndex);
            storage.save(tasks);
            printer.showDelete(deleteTask, tasks.size());
            break;

        default:
            throw new InvalidCommandException();
        }
    }
}