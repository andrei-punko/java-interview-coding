package by.andd3dfx.collections.custom;

import lombok.AllArgsConstructor;

import java.util.Iterator;

/**
 * @see <a href="https://youtu.be/vHjvNHBQP3o">Video solution</a>
 */
public class CustomLinkedList<T> implements Iterable<T> {

    @AllArgsConstructor
    public static class Node<M> {
        private M value;
        private Node<M> next;

        @Override
        public String toString() {
            if (next == null) {
                return "{%s}".formatted(value);
            }
            return "{%s, next=%s}".formatted(value, next);
        }
    }

    private Node<T> head;
    private int size = 0;

    public void add(T value) {
        add(size, value);
    }

    public void add(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = new Node<>(value, head);
            size++;
            return;
        }

        int i = 1;
        Node<T> prev = head;
        Node<T> curr = head.next;
        while (i < index) {
            i++;
            prev = curr;
            curr = curr.next;
        }
        prev.next = new Node<>(value, curr);
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Wrong index: %d", index));
        }

        int i = 0;
        var curr = head;
        while (i < index) {
            i++;
            curr = curr.next;
        }
        return curr.value;
    }

    public T set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Wrong index: %d", index));
        }

        int i = 0;
        var curr = head;
        while (i < index) {
            i++;
            curr = curr.next;
        }
        curr.value = value;
        return curr.value;
    }

    public T remove() {
        return remove(0);
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Wrong index: %d", index));
        }

        if (index == 0) {
            T result = head.value;
            head = head.next;
            size--;
            return result;
        }

        int i = 1;
        var prev = head;
        var curr = head.next;
        while (i < index) {
            i++;
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        size--;

        return curr.value;
    }

    public boolean remove(T value) {
        var i = 0;
        var curr = head;
        while (curr != null) {
            if (checkEquality(value, curr.value)) {
                remove(i);
                return true;
            }
            i++;
            curr = curr.next;
        }
        return false;
    }

    private boolean checkEquality(T value1, T value2) {
        if (value1 == null) {
            return value2 == null;
        }
        return value1.equals(value2);
    }

    public void push(T item) {
        add(0, item);
    }

    public T pop() {
        return remove(0);
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> curr = head;

        while (curr != null) {
            Node<T> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator<>(head);
    }

    @AllArgsConstructor
    public static class CustomIterator<E> implements Iterator<E> {
        private Node<E> curr;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public E next() {
            var result = curr.value;
            curr = curr.next;
            return result;
        }
    }

    @Override
    public String toString() {
        return "CustomLinkedList{head=%s}".formatted(head);
    }
}
