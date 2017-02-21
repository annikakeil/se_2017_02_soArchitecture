package airplain.events;

public class Event {
    protected int id;
    protected String message;

    public Event(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
