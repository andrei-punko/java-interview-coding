package by.andd3dfx.common;

import java.util.Iterator;
import java.util.Map;

/**
 * <pre>
 * We have an interface:
 * public interface Condition<K> {
 *     boolean check(K key);
 * }
 *
 * Implement class with method to filter items in map in case if key satisfy to check(K key) method.
 * </pre>
 */
public class SkipItemsByCondition {

    public interface Condition<K> {
        boolean check(K key);
    }

    public <K, V> Map<K, V> filterUsingIterator(Map<K, V> map, Condition<K> condition) {
        Iterator<K> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            K key = iterator.next();
            if (condition.check(key)) {
                iterator.remove();
            }
        }
        return map;
    }

    public <K, V> Map<K, V> filterUsingRemoveIf(Map<K, V> map, Condition<K> condition) {
        map.keySet().removeIf(condition::check);
        return map;
    }
}
