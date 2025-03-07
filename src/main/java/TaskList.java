import javax.sound.sampled.Line;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        System.out.println(Constants.LINE + System.lineSeparator()
                + "added: " + task + "\n"
                + Constants.LINE);
    }

    public void listTasks() {
        System.out.println(Constants.LINE);
        if (tasks.isEmpty()) {
            System.out.println("No tasks added yet.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
        System.out.println(Constants.LINE);
    }
}
