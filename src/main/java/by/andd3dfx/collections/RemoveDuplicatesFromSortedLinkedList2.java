package by.andd3dfx.collections;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <pre>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers
 * from the original list. Return the linked list sorted as well.
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 * The list is guaranteed to be sorted in ascending order.
 * </pre>
 */
public class RemoveDuplicatesFromSortedLinkedList2 {

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
                return "{%d}".formatted(value);
            }
            return "{%d, n=%s}".formatted(value, next);
        }
    }

    public static Node remove(Node head) {
        if (head == null) {
            return null;
        }

        Deque<Node> stack = new ArrayDeque<>();
        var curr = head;
        stack.push(curr);
        while (curr.next != null) {
            curr = curr.next;

            if (curr.value == stack.peek().value) {
                while (curr.value == stack.peek().value) {
                    curr = curr.next;
                }
                stack.pop();

                var prev = stack.pop();
                prev.next = curr;
            }
            stack.push(curr);
        }

        return head;
    }
}
