package kyro.exceptions;

public class InvalidCommandException extends KyroException {
    public InvalidCommandException() {
        super("Kyro has no clue what you're saying...");
    }
}
