package by.andd3dfx.collections.custom;

import java.util.Collection;
import java.util.Iterator;

public class CustomHashSet<T> implements Iterable<T> {

    private CustomHashMap<T, Object> map = new CustomHashMap<>();
    private static final Object DUMMY_VALUE = new Object();

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean add(T item) {
        return map.put(item, DUMMY_VALUE) == null;
    }

    public boolean addAll(Collection<T> items) {
        boolean result = false;
        for (var item : items) {
            if (add(item)) {
                result = true;
            }
        }
        return result;
    }

    public boolean remove(T item) {
        return map.remove(item) != null;
    }

    public boolean removeAll(Collection<T> items) {
        boolean result = false;
        for (var item : items) {
            if (remove(item)) {
                result = true;
            }
        }
        return result;
    }

    public boolean contains(T item) {
        return map.containsKey(item);
    }

    public boolean containsAll(Collection<T> items) {
        for (var item : items) {
            if (!map.containsKey(item)) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        map.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return map.keyIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var item : map.keySet()) {
            sb.append(item + ", ");
        }
        return "[" + sb.substring(0, sb.length() - 2).toString() + "]";
    }
}
