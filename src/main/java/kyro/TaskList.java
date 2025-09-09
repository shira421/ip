package kyro;

import kyro.tasks.*;
import kyro.exceptions.*;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public void remove(int index) throws InvalidTaskNumberException {
        if (index < 0 || index >= tasks.size()) {
            throw new InvalidTaskNumberException();
        }
        tasks.remove(index);
    }

    public Task get(int index) throws InvalidTaskNumberException {
        if (index < 0 || index >= tasks.size()) {
            throw new InvalidTaskNumberException();
        }
        return tasks.get(index);
    }

    public int size() {
        return tasks.size();
    }

    public ArrayList<Task> getTaskList() {
        return new ArrayList<>(tasks);
    }
}
