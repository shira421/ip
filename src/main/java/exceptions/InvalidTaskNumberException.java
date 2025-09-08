package exceptions;

public class InvalidTaskNumberException extends KyroException {
    public InvalidTaskNumberException() {
        super("Kyro thinks you need to learn how to count again...");
    }
}
