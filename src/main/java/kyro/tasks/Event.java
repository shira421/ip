package kyro.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task that spans a period of time.
 * <p>
 * An {@code Event} has a description, a start date/time, and an end date/time.
 */
public class Event extends Task {

    protected LocalDateTime from;
    protected LocalDateTime to;

    /**
     * Constructs a new {@code Event} task.
     *
     * @param description The description of the event.
     * @param from        The start time in {@code yyyy-MM-dd HHmm} format.
     * @param to          The end time in {@code yyyy-MM-dd HHmm} format.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = LocalDateTime.parse(from, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
        this.to = LocalDateTime.parse(to, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
    }

    /**
     * Returns the start time of this event.
     *
     * @return The {@link LocalDateTime} representing the start time.
     */
    public LocalDateTime getFrom() {
        return from;
    }

    /**
     * Returns the end time of this event.
     *
     * @return The {@link LocalDateTime} representing the end time.
     */
    public LocalDateTime getTo() {
        return to;
    }

    /**
     * Returns a string representation of this event for display.
     *
     * @return A formatted string with type, description, start, and end times.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString()
                + " (from: " + from.format(DateTimeFormatter.ofPattern("MMM dd yyyy, h:mma"))
                + " to: " + to.format(DateTimeFormatter.ofPattern("MMM dd yyyy, h:mma")) + ")";
    }

    /**
     * Returns a string representation of this event for saving to file.
     *
     * @return A formatted string with type, status, description, start, and end times.
     */
    @Override
    public String toSave() {
        return "E | " + super.toSave()
                + " | " + from.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"))
                + " | " + to.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
    }
}
