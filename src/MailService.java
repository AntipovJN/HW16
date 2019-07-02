import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<S> implements Consumer<Sendable<S>> {

    private Map<String, List<S>> mailBox = new HashMap<String, List<S>>(){
        @Override
        public List<S> get(Object key) {
            return super.getOrDefault(key,new LinkedList<>());
        }
    };

    public Map<String, List<S>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Sendable<S> message) {
            List<S> list = mailBox.get(message.getTo());
            S s =  message.getContent();
            list.add(s);
        mailBox.put(message.getTo(), list);
    }
}
