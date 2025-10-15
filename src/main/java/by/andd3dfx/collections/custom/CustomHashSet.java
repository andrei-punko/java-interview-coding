package by.andd3dfx.collections.custom;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * @see <a href="https://youtu.be/aTbKxApYNYk">Video solution</a>
 */
public class CustomHashSet<T> implements Collection<T> {

    private CustomHashMap<T, Object> map = new CustomHashMap<>();
    private static final Object DUMMY_VALUE = new Object();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean add(T item) {
        return map.put(item, DUMMY_VALUE) == null;
    }

    @Override
    public boolean addAll(Collection<? extends T> items) {
        boolean result = false;
        for (var item : items) {
            if (add(item)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean remove(Object item) {
        return map.remove(item) == DUMMY_VALUE;
    }

    @Override
    public boolean removeAll(Collection<?> items) {
        boolean result = false;
        for (var item : items) {
            if (remove(item)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        var modified = false;
        final Iterator<T> iterator = iterator();

        while (iterator.hasNext()) {
            final T item = iterator.next();
            if (!c.contains(item)) {
                iterator.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean contains(Object item) {
        return map.containsKey(item);
    }

    @Override
    public boolean containsAll(Collection<?> items) {
        for (var item : items) {
            if (!map.containsKey(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return map.keyIterator();
    }

    @Override
    public Object[] toArray() {
        var list = new CustomArrayList<>();
        var iterator = map.keyIterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        var src = toArray();
        var result = (T1[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size());

        System.arraycopy(src, 0, result, 0, size());

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        var it = iterator();
        while (it.hasNext()) {
            final T item = it.next();
            sb.append(item + ", ");
        }
        return "[" + sb.substring(0, sb.length() - 2) + "]";
    }
}
