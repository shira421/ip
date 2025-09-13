package kyro.base;

import kyro.exceptions.*;

public class Parser {
    public static Command parse(String input) throws KyroException {
        String[] parts = input.trim().split(" ", 2);
        String command = parts[0].toLowerCase();

        switch (command) {
        case "bye":
            return new Command(CommandList.BYE);

        case "list":
            return new Command(CommandList.LIST);

        case "mark":
            if (parts.length < 2) {
                throw new KyroException("Kyro thinks you should provide a task number to mark.");
            }
            return new Command(CommandList.MARK, parts[1]);

        case "unmark":
            if (parts.length < 2) {
                throw new KyroException("Kyro thinks you should provide a task number to unmark.");
            }
            return new Command(CommandList.UNMARK, parts[1]);

        case "todo":
            if (parts.length < 2 || parts[1].trim().isEmpty()) {
                throw new MissingDescriptionException("todo");
            }
            return new Command(CommandList.TODO, parts[1]);

        case "deadline":
            if (parts.length < 2 || !parts[1].contains(" /by ")) {
                throw new KyroException("Kyro thinks you should follow the format: deadline <description> /by <yyyy-MM-dd>");
            }
            return new Command(CommandList.DEADLINE, parts[1]);

        case "event":
            if (parts.length < 2 || !parts[1].contains(" /from ") || !parts[1].contains(" /to ")) {
                throw new KyroException("Kyro thinks you should follow the format: event <description> /from <yyyy-MM-dd> /to <yyyy-MM-dd>");
            }
            return new Command(CommandList.EVENT, parts[1]);

        case "delete":
            if (parts.length < 2) {
                throw new KyroException("Kyro thinks you should provide a task number to delete.");
            }
            return new Command(CommandList.DELETE, parts[1]);

        case "filter":
            if (parts.length < 2 || parts[1].trim().isEmpty()) {
                throw new KyroException("Kyro thinks you should follow the format: filter <yyyy-MM-dd>");
            }
            return new Command(CommandList.FILTER, parts[1]);

        case "find":
            if (parts.length < 2 || parts[1].trim().isEmpty()) {
                throw new KyroException("Kyro thinks you should follow the format: find <description>");
            }
            return new Command(CommandList.FIND, parts[1]);

        default:
            throw new InvalidCommandException();
        }
    }
}
