package by.andd3dfx.collections;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">Task description</a>
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Constraints:
 *     The number of nodes in the list is sz.
 *     1 <= sz <= 30
 *     0 <= Node.val <= 100
 *     1 <= n <= sz
 * </pre>
 *
 * @see <a href="https://youtu.be/Ant-eAAwyx8">Video solution</a>
 */
public class RemoveNthNodeFromLinkedListEnd {

    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        var newHead = new ListNode();
        newHead.next = head;

        var first = newHead;
        var second = newHead;

        for (var i = 0; i < n; i++) {
            second = second.next;
        }

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;

        return newHead.next;
    }
}
