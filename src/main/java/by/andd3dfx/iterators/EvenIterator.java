package by.andd3dfx.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Build iterator which returns only even numbers of underlying array:
 * [1, 3, 5, 7, 8, 9] -> [8]
 */
public class EvenIterator implements Iterator<Integer> {

    private final Iterator<Integer> it;
    private Stack<Integer> stack = new Stack<>();

    public EvenIterator(Iterator<Integer> it) {
        this.it = it;
    }

    @Override
    public Integer next() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }

        while (it.hasNext()) {
            Integer value = it.next();
            if (value % 2 == 0) {
                stack.push(value);
                break;
            }
        }

        if (!it.hasNext()) {
            throw new NoSuchElementException("Iterator is empty!");
        }
        return stack.pop();
    }

    @Override
    public boolean hasNext() {
        if (!stack.isEmpty()) {
            return true;
        }

        while (it.hasNext()) {
            stack.push(it.next());

            if (stack.peek() % 2 == 0) {
                break;
            }

            stack.pop();
        }

        if (!stack.isEmpty()) {
            return true;
        }
        return it.hasNext();
    }
}
