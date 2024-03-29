package by.andd3dfx.iterators;

import java.util.Iterator;

/**
 * Реализовать методы next(), hasNext(), remove() у составного итератора, содержащего 2 обычных итератора внутри себя:
 * <pre>
 * class CompositeIterator<Integer> {
 *   Iterator<Integer> a;
 *   Iterator<Integer> b;
 * }
 * </pre>
 */
public class CompositeIterator<T> implements Iterator<T> {

    private final Iterator<T> a;
    private final Iterator<T> b;
    private Iterator<T> currentIterator;

    public CompositeIterator(Iterator<T> a, Iterator<T> b) {
        this.a = a;
        this.b = b;
        currentIterator = a;
    }

    @Override
    public boolean hasNext() {
        if (currentIterator == a && !currentIterator.hasNext()) {
            currentIterator = b;
        }
        return currentIterator.hasNext();
    }

    @Override
    public T next() {
        if (currentIterator == a && !currentIterator.hasNext()) {
            currentIterator = b;
        }
        return currentIterator.next();
    }

    @Override
    public void remove() {
        if (currentIterator == a && !currentIterator.hasNext()) {
            currentIterator = b;
        }
        currentIterator.remove();
    }
}
