package by.andd3dfx.collections.custom;

import java.util.Collection;

public class CustomHashSet<T> {

    private CustomHashMap<T, Object> map = new CustomHashMap<>();
    private static final Object DUMMY_VALUE = new Object();

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean add(T item) {
        return map.put(item, DUMMY_VALUE) != null;
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
}
