package exceptions;

public class MissingDescriptionException extends KyroException {
    public MissingDescriptionException(String type) {
        super("Kyro thinks the description of a " + type + " cannot be empty...");
    }
}
