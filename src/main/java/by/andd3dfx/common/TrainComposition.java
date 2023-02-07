package by.andd3dfx.common;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A TrainComposition is built by attaching and detaching wagons from the left and the right sides.
 * <p>
 * For example, if we start by attaching wagon 7 from the left followed by attaching wagon 13, again from the left, we get
 * a composition of two wagons (13 and 7 from left to right). Now the first wagon that can be detached from the right is 7
 * and the first that can be detached from the left is 13.
 * <p>
 * Implement a TrainComposition that models this problem.
 */
public class TrainComposition {

    private Deque<Integer> deque = new ArrayDeque<>();

    public void attachWagonFromLeft(int wagonId) {
        deque.addFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        deque.addLast(wagonId);
    }

    public int detachWagonFromLeft() {
        return deque.removeFirst();
    }

    public int detachWagonFromRight() {
        return deque.removeLast();
    }
}
