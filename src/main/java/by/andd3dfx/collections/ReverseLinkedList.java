package by.andd3dfx.collections;

import lombok.AllArgsConstructor;

import java.util.Stack;

/**
 * Reverse linked list
 */
public class ReverseLinkedList {

    @AllArgsConstructor
    public static class ListNode {
        public ListNode next;
        public int val;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        ListNode newHead = stack.pop();
        newHead.next = null;

        ListNode currItem = newHead;
        while (!stack.isEmpty()) {
            currItem.next = stack.pop();
            currItem = currItem.next;
        }
        currItem.next = null;

        return newHead;
    }
}
