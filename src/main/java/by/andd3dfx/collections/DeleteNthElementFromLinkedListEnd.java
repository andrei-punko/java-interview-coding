package by.andd3dfx.collections;

import lombok.AllArgsConstructor;
import lombok.Data;

public class DeleteNthElementFromLinkedListEnd {

    @Data
    @AllArgsConstructor
    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "{%d, next=%s}".formatted(value, next);
        }
    }

    public static void apply(Node head, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be >=0!");
        }

        int counter = n;
        var fastPointer = head;
        while (counter >= 0) {
            if (fastPointer == null) {
                throw new IllegalArgumentException("n should be less than list size!");
            }
            fastPointer = fastPointer.next;
            counter--;
        }

        var slowPointer = head;
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        slowPointer.next = slowPointer.next.next;
    }
}
