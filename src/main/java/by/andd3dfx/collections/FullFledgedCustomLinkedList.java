package by.andd3dfx.collections;

import lombok.AllArgsConstructor;
import lombok.ToString;

public class FullFledgedCustomLinkedList<T> {

    @ToString
    @AllArgsConstructor
    public class Node {
        private T value;
        private Node next;
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public void reverse() {
        Node prev = null;
        Node curr = head;
        tail = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void add(T value) {
        Node node = new Node(value, null);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index >= size) {
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

    @Override
    public String toString() {
        return "CustomLinkedList{" +
                "head=" + head +
                '}';
    }
}
