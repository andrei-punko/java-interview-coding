package by.andd3dfx.interview.train2021;

import java.util.Iterator;
import java.util.Stack;

/**
 * Build iterator which returns only even numbers of underlying array:
 * [1, 3, 5, 7, 8] -> [8]
 */
public class EvenIterator implements Iterator<Integer> {

    private Iterator<Integer> it;
    private Stack<Integer> lastItem = new Stack<>();

    public EvenIterator(Iterator<Integer> it) {
        this.it = it;
    }

    @Override
    public Integer next() {
        if (!lastItem.isEmpty()) {
            return lastItem.pop();
        }

        while (it.hasNext()) {
            Integer value = it.next();
            if (value % 2 == 1) {
                continue;
            } else {
                lastItem.push(value);
                break;
            }
        }

        if (!it.hasNext()) {
            throw new IllegalStateException("Next element does not exist!");
        }
        return lastItem.pop();
    }

    @Override
    public boolean hasNext() {
        if (!lastItem.isEmpty()) {
            return true;
        }

        boolean nextCalled = false;
        while (it.hasNext()) {
            lastItem.push(it.next());
            nextCalled = true;

            if (lastItem.peek() % 2 == 1) {
                lastItem.pop();
                nextCalled = false;
                continue;
            } else {
                break;
            }
        }

        if (nextCalled && !lastItem.isEmpty()) {
            return true;
        }
        return it.hasNext();
    }
}
