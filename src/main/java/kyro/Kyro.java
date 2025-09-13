package kyro;

import kyro.exceptions.*;

import java.util.Scanner;

public class Kyro {
    private final Printer printer;
    private final Storage storage;
    private final TaskList tasks;
    private final Scanner scanner;

    public Kyro(String filePath) {
        printer = new Printer();
        storage = new Storage(filePath);
        tasks = storage.load();
        scanner = new Scanner(System.in);
    }

    public void run() {
        printer.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = scanner.nextLine();
                printer.showLine();
                Command command = Parser.parse(fullCommand);
                command.execute(tasks, printer, storage);
                isExit = command.isExit();
            } catch (KyroException e) {
                printer.showError(e.getMessage());
            } catch (NumberFormatException e) {
                printer.showError("Kyro thinks you need to go back to school to learn what numbers are...");
            } finally {
                printer.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Kyro("./data/kyro.txt").run();
    }
}