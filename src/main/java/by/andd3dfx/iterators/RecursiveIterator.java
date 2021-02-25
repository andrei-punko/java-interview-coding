package by.andd3dfx.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/*
Дан итератор CustomIterator<Object>, который может возвращать String или CustomIterator.
Возможная вложенность внутренних итераторов неограниченна.

Написать для него методы next() и hasNext()
*/
public class RecursiveIterator<Object> implements Iterator<Object> {

    private Stack<Iterator<Object>> stack = new Stack<>();

    public RecursiveIterator(Iterator<Object> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        return determineHasNext();
    }

    private boolean determineHasNext() {
        if (stack.isEmpty()) {
            return false;
        }

        Iterator<Object> currentIterator = stack.peek();
        if (!currentIterator.hasNext()) {
            stack.pop();
            return determineHasNext();
        }
        return true;
    }

    @Override
    public Object next() {
        return determineNext();
    }

    private Object determineNext() {
        if (stack.empty()) {
            throw new NoSuchElementException();
        }
        Iterator<Object> currentIterator = stack.peek();

        if (!currentIterator.hasNext()) {
            stack.pop();
            return determineNext();
        }

        Object object = currentIterator.next();
        if (object instanceof String) {
            return object;
        }
        stack.push((Iterator<Object>) object);
        return determineNext();
    }
}
