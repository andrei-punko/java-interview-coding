package by.andd3dfx.iterators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Дан итератор CustomIterator<Object>, который может возвращать String или CustomIterator.
 * Возможная вложенность внутренних итераторов неограниченна.
 * <p>
 * Написать для него методы next() и hasNext()
 */
public class RecursiveIterator<Object> implements Iterator<Object> {

    private Deque<Iterator<Object>> stack = new ArrayDeque<>();

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
