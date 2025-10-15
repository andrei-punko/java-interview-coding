package by.andd3dfx.collections.custom;

import java.util.Iterator;

/**
 * @see <a href="https://youtu.be/GlV87RWHhOQ">Video solution</a>
 */
public class CustomLinkedHashSet<T> extends CustomHashSet<T> {

    private CustomLinkedList<T> linkedList = new CustomLinkedList<>();

    @Override
    public boolean add(T item) {
        final boolean result = super.add(item);
        if (result) {
            linkedList.add(item);
        }
        return result;
    }

    @Override
    public boolean remove(Object item) {
        final boolean result = super.remove(item);
        if (result) {
            linkedList.remove(item);
        }
        return result;
    }

    @Override
    public void clear() {
        super.clear();
        linkedList = new CustomLinkedList<>();
    }

    @Override
    public Iterator<T> iterator() {
        return linkedList.iterator();
    }
}
