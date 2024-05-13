package by.andd3dfx.collections;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <pre>
 * https://leetcode.com/problems/rotate-list/
 *
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 *
 * Example 2:
 *
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 * </pre>
 *
 * @see <a href="https://youtu.be/6tyflwO6PwY">Video solution</a>
 */
public class RotateLinkedList {

    @Data
    @AllArgsConstructor
    public static class ListNode {
        private int val;
        private ListNode next;

        @Override
        public String toString() {
            return "Node{v=%d}".formatted(val);
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }

        var endItem = head;
        var size = 1;
        while (endItem.next != null) {
            endItem = endItem.next;
            size++;             // measuring list size in background
        }
        endItem.next = head;
        k %= size;              // optimization: reduce amount of work

        var curr = endItem;
        int i = 0;
        while (i < size - k) {
            curr = curr.next;
            i++;
        }

        var result = curr.next;
        curr.next = null;
        return result;
    }

    public static ListNode rotateLeft(ListNode head, int k) {
        return rotateRight(head, -k);
    }
}
