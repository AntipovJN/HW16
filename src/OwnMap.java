import java.util.HashMap;
import java.util.LinkedList;

public class OwnMap<K, V> extends HashMap<K, V> {

    @Override
    public V get(Object key) {
        return super.getOrDefault(key, (V) new LinkedList<V>());
    }
}

