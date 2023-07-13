package by.andd3dfx.collections;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <pre>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 *
 * Input: head = [1,1,2]
 * Output: [1,2]
 *
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 *
 * The list is guaranteed to be sorted in ascending order.
 * </pre>
 */
public class RemoveDuplicatesFromSortedLinkedList {

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
            if (next == null) {
                return "%d".formatted(value);
            }
            return "%d->%s".formatted(value, next);
        }
    }

    public static Node remove(Node head) {
        if (head == null) {
            return null;
        }

        var last = head;
        var curr = head.next;

        while (curr != null) {
            if (last.value == curr.value) {
                last.next = curr.next;
            } else {
                last = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
