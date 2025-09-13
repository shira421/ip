package kyro.base;

import kyro.tasks.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public TaskList load() {
        TaskList tasks = new TaskList();
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
                return tasks;
            }

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try {
                    Task task = parseTask(line);
                    tasks.add(task);
                } catch (Exception e) {
                    System.out.println("Skipping corrupted line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return tasks;
    }

    public void save(TaskList tasks) {
        try {
            FileWriter fw = new FileWriter(filePath);
            for (int i = 0; i < tasks.getTaskList().size(); i++) {
                Task task = tasks.getTaskList().get(i);
                fw.write(task.toSave() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private Task parseTask(String line) {
        String[] parts = line.split(" \\| ");
        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        switch (type) {
        case "T":
            Task todo = new Todo(description);
            todo.setDone(isDone);
            return todo;
        case "D":
            Task deadline = new Deadline(description, parts[3]);
            deadline.setDone(isDone);
            return deadline;
        case "E":
            Task event = new Event(description, parts[3], parts[4]);
            event.setDone(isDone);
            return event;
        default:
            throw new IllegalArgumentException("Unknown task type: " + type);
        }
    }
}
