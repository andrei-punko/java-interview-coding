package by.andd3dfx.collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <pre>
 * Напишите стек, который поддерживает следующие операции:
 * - push(x) – кладет элемент в стек
 * - pop() – берет элемент из стека
 * - getMin() – возвращает значение минимального элемента в стеке
 * Методы pop() и getMin() вызываются всегда для непустого стека.
 *
 * push() and getMin() should have O(1) complexity.
 * </pre>
 *
 * @see <a href="https://youtu.be/-Y-_0R8tfyk">Video solution</a>
 */
public class StackWithMinSupportO1 {

    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> minHistoryStack = new ArrayDeque<>();

    public void push(int element) {
        stack.push(element);

        if (minHistoryStack.isEmpty() || element <= minHistoryStack.peek()) {
            minHistoryStack.push(element);
        }
    }

    public int pop() {
        var result = stack.pop();
        if (minHistoryStack.peek() == result) {
            minHistoryStack.pop();
        }
        return result;
    }

    public int getMin() {
        return minHistoryStack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
