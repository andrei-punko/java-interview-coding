package by.andd3dfx.iterators;

import java.util.Iterator;

/**
 * <pre>
 * Реализовать методы next(), hasNext(), remove() у составного итератора, содержащего 2 обычных итератора внутри себя:
 *
 * class CompositeIterator&lt;Integer&gt; {
 *   Iterator&lt;Integer&gt; a;
 *   Iterator&lt;Integer&gt; b;
 * }
 * </pre>
 *
 * @see <a href="https://youtu.be/8V_t64QLN7Q">Video solution</a>
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
