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
    private Object nextElement;

    public RecursiveIterator(Iterator<Object> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (nextElement != null) {
            return true;
        }
        nextElement = determineNextElement();
        return nextElement != null;
    }

    @Override
    public Object next() {
        var result = determineNextElement();
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    private Object determineNextElement() {
        if (nextElement != null) {
            var result = nextElement;
            nextElement = null;
            return result;
        }

        if (stack.isEmpty()) {
            return null;
        }

        while (!stack.isEmpty()) {
            Iterator<Object> iterator = stack.peek();
            if (iterator.hasNext()) {
                var next = iterator.next();

                if (next instanceof Iterator) {
                    stack.push((Iterator<Object>) next);
                    return determineNextElement();
                } else {
                    return next;
                }
            } else {
                stack.pop();
            }
        }
        return null;
    }
}
