package by.andd3dfx.interview.train2021;

import java.util.Iterator;

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
}
