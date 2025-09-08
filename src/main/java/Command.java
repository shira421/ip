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

    public CommandList getType() {
        return type;
    }

    public String getArguments() {
        return arguments;
    }
}
