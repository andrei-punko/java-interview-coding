package by.andd3dfx.iterators;

import java.util.Iterator;

public class CompositeIterator2<T> implements Iterator<T> {

    private final Iterator<T> a;
    private final Iterator<T> b;
    private Iterator<T> currentIterator;

    public CompositeIterator2(Iterator<T> a, Iterator<T> b) {
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
}
