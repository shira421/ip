package kyro.exceptions;

public class TaskLimitException extends KyroException {
    public TaskLimitException(int max) {
        super("Kyro thinks your schedule is a little full... (" + max + ").");
    }
}
