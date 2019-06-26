import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<S> implements Consumer<Sendable<S>> {

    private OwnMap<String, List<S>> mailBox = new OwnMap<>();

    public Map<String, List<S>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Sendable<S> message) {
        List<S> list;
        if (mailBox.get(message.getTo()) == null) {
            list = new LinkedList<>();
        } else {
            list = mailBox.get(message.getTo());
        }
        try {
            S s = (S) message.getContent();
            list.add(s);
        } catch (ClassCastException e) {}
        mailBox.put(message.getTo(), list);
    }
}
