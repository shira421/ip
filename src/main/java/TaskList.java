import exceptions.InvalidTaskNumberException;
import exceptions.TaskLimitException;

public class TaskList {
    private static final int MAX_TASKS = 100;
    private final Task[] tasks;
    private int size;

    public TaskList() {
        tasks = new Task[MAX_TASKS];
        size = 0;
    }

    public void add(Task task) throws TaskLimitException {
        if (size >= MAX_TASKS) {
            throw new TaskLimitException(MAX_TASKS);
        }
        tasks[size] = task;
        size++;
    }

    public Task get(int index) throws InvalidTaskNumberException {
        if (index < 0 || index >= size) {
            throw new InvalidTaskNumberException();
        }
        return tasks[index];
    }

    public int size() {
        return size;
    }

    public Task[] getAll() {
        Task[] copy = new Task[size];
        System.arraycopy(tasks, 0, copy, 0, size);
        return copy;
    }
}
