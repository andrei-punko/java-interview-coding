package by.andd3dfx.collections;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

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
 */
public class StackWithMinSupport {

    private Deque<Integer> stack = new ArrayDeque<>();
    private PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(value -> value));

    public void push(int element) {
        stack.push(element);
        queue.add(element);
    }

    public int pop() {
        Integer item = stack.pop();
        queue.remove(item);
        return item;
    }

    public int getMin() {
        return queue.peek();
    }
}
