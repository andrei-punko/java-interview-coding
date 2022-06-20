package by.andd3dfx.collections;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Напишите стек, который поддерживает следующие операции:
 * <pre>
 * push(x) – кладет элемент в стек
 * pop() – берет элемент из стека
 * getMin() – возвращает значение минимального элемента в стеке
 * </pre>
 * Методы pop() и getMin() вызываются всегда для непустого стека.
 */
public class CustomStackWithMinSupport {

    private LinkedList<Integer> list = new LinkedList<>();
    private PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(value -> value));

    public void push(int element) {
        list.push(element);
        queue.add(element);
    }

    public int pop() {
        Integer item = list.pop();
        queue.remove(item);
        return item;
    }

    public int getMin() {
        return queue.peek();
    }
}
