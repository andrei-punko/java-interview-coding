package by.andd3dfx.interview.train2021;

public class CompactLinkedList<T> {

    Node head;

    public CompactLinkedList(Node head) {
        this.head = head;
    }

    public static class Node<T> {
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
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

    public void recursiveReverse() {
        head = recursion(null, head);
    }

    private Node recursion(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }
        Node next = curr.next;
        curr.next = prev;
        return recursion(curr, next);
    }

    @Override
    public String toString() {
        return "CompactLinkedList{" +
                "head=" + head +
                '}';
    }
}
