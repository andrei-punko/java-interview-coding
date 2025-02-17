package by.andd3dfx.iterators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <pre>
 * Дан итератор CustomIterator&lt;Object&gt;, который может возвращать String или CustomIterator.
 * Возможная вложенность внутренних итераторов неограниченна.
 *
 * Написать для него методы next() и hasNext()
 * </pre>
 *
 * @see <a href="https://youtu.be/dnR4xhkdx1I">Video solution</a>
 */
public class RecursiveIterator<Object> implements Iterator<Object> {

    private final Deque<Iterator<Object>> stack = new ArrayDeque<>();

    public RecursiveIterator(Iterator<Object> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }

        Iterator<Object> currentIterator = stack.peek();
        if (currentIterator.hasNext()) {
            return true;
        }
        stack.pop();
        return hasNext();
    }

    @Override
    public Object next() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }

        Iterator<Object> currentIterator = stack.peek();
        if (!currentIterator.hasNext()) {
            stack.pop();
            return next();
        }

        Object object = currentIterator.next();
        if (object instanceof String) {
            return object;
        }
        stack.push((Iterator<Object>) object);
        return next();
    }
}
