package by.andd3dfx.collections.custom;

import java.util.NoSuchElementException;

/**
 * @see <a href="https://youtu.be/sZ-DrSHhrWc">Video solution</a>
 */
public class CustomStack<T> {

    private final CustomLinkedList<T> linkedList = new CustomLinkedList<>();

    public void push(T item) {
        linkedList.push(item);
    }

    public T pop() {
        try {
            return linkedList.pop();
        } catch (IndexOutOfBoundsException ex) {
            throw new NoSuchElementException(ex);
        }
    }

    public T peek() {
        try {
            return linkedList.get(0);
        } catch (IndexOutOfBoundsException ex) {
            throw new NoSuchElementException(ex);
        }
    }

    public int size() {
        return linkedList.size();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
