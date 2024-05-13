package by.andd3dfx.collections;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Find loop in the linked list
 *
 * @see <a href="https://youtu.be/5IcvvtfLGvM">Video solution</a>
 */
public class LoopInLinkedList {

    @Data
    @AllArgsConstructor
    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isPresent(Node head) {
        var slow = head;
        var fast = head;

        while (true) {
            fast = fast.next;
            if (fast == slow) {
                return true;
            }
            if (fast == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast == slow) {
                return true;
            }
            if (fast == null) {
                return false;
            }
        }
    }
}
