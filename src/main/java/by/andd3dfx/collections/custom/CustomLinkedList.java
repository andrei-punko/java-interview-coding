package by.andd3dfx.collections.custom;

import lombok.AllArgsConstructor;

public class CustomLinkedList<T> {

    @AllArgsConstructor
    public class Node {
        private T value;
        private Node next;

        @Override
        public String toString() {
            if (next == null) {
                return "{%s}".formatted(value);
            }
            return "{%s, next=%s}".formatted(value, next);
        }
    }

    private Node head;
    private int size = 0;

    public void add(T value) {
        add(size, value);
    }

    public void add(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            var newNode = new Node(value, head);
            head = newNode;
            size++;
            return;
        }

        int i = 1;
        Node prev = head;
        Node curr = head.next;
        while (i < index) {
            i++;
            prev = curr;
            curr = curr.next;
        }
        var newNode = new Node(value, curr);
        prev.next = newNode;
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
        Node curr = head;
        while (i < index) {
            i++;
            curr = curr.next;
        }
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
        Node prev = head;
        Node curr = head.next;
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
            if ((value == null && curr.value == null) || value.equals(curr.value)) {
                remove(i);
                return true;
            }
            i++;
            curr = curr.next;
        }
        return false;
    }

    public void push(T item) {
        add(0, item);
    }

    public T pop() {
        return remove(0);
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        return "CustomLinkedList{head=%s}".formatted(head);
    }
}
