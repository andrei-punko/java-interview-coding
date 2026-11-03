package by.andd3dfx.collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">Task description</a>
 *
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 *
 * Example 1:
 *
 * <img src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg"/>
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Example 2:
 *
 * <img src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg"/>
 * Input: head = [1,2]
 * Output: false
 * </pre>
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null) {
            fast = fast.next;

            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        var curr = slow;    // middle of linked list found

        // Put second half of linked list into stack, reversed
        Deque<Integer> stack = new ArrayDeque<>();
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }

        // Compare first part of linked list with stack content
        curr = head;
        while (!stack.isEmpty()) {
            var stackValue = stack.pop();
            if (stackValue != curr.val) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
