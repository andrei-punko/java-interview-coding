package by.andd3dfx.iterators;

import lombok.RequiredArgsConstructor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Build iterator which returns only even numbers of underlying array:
 * [1, 3, 5, 7, 8, 9] -> [8]
 */
@RequiredArgsConstructor
public class EvenIterator implements Iterator<Integer> {

    private final Iterator<Integer> it;
    private Deque<Integer> stack = new ArrayDeque<>();

    @Override
    public Integer next() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }

        while (it.hasNext()) {
            Integer value = it.next();
            if (value % 2 == 0) {
                return value;
            }
        }
        throw new NoSuchElementException("Iterator is empty!");
    }

    @Override
    public boolean hasNext() {
        if (!stack.isEmpty()) {
            return true;
        }

        while (it.hasNext()) {
            var value = it.next();
            if (value % 2 == 0) {
                stack.push(value);
                break;
            }
        }

        if (stack.isEmpty()) {
            return it.hasNext();
        }
        return true;
    }
}
