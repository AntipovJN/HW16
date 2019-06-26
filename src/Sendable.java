public  abstract class Sendable<T> {
    private String from;
    private String to;
    private T message;

    public Sendable(String from, String to, T message) {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public T getContent() {
        return message;
    }
}
