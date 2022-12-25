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

    /**
     * This main method was part of the task
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(new ListNode(new ListNode(new ListNode(null, 3), 4), 5), 6);
        printLinkedList(head);

        ListNode current = reverse(head);

        printLinkedList(current);
    }

    private static void printLinkedList(ListNode current) {
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
