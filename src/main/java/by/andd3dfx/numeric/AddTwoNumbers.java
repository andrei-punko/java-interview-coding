package by.andd3dfx.numeric;

import java.util.Iterator;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/add-two-numbers/description/">Task description</a>
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *   Input: l1 = [2,4,3], l2 = [5,6,4]
 *   Output: [7,0,8]
 *   Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *   Input: l1 = [0], l2 = [0]
 *   Output: [0]
 *
 * Example 3:
 *   Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 *   Output: [8,9,9,9,0,0,0,1]
 * </pre>
 *
 * @see <a href="https://youtu.be/RKAeQ1o5pRo">Video solution</a>
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var iterator1 = new DigitsIterator(l1);
        var iterator2 = new DigitsIterator(l2);

        var res = new ListNode();
        var accumulator = 0;
        var curr = res;
        while (iterator1.hasNext() || iterator2.hasNext() || accumulator > 0) {
            var n1 = iterator1.hasNext() ? iterator1.next() : 0;
            var n2 = iterator2.hasNext() ? iterator2.next() : 0;
            accumulator = calcAccumulator(n1 + n2 + accumulator, curr);
            curr = curr.next;
        }
        return res.next;
    }

    private static int calcAccumulator(int sum, ListNode curr) {
        if (sum <= 9) {
            curr.next = new ListNode(sum);
        } else {
            curr.next = new ListNode(sum % 10);
        }
        return sum / 10;
    }

    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "{%d -> %s}".formatted(val, next);
        }
    }

    public static class DigitsIterator implements Iterator<Integer> {

        private ListNode listNode;

        public DigitsIterator(ListNode listNode) {
            this.listNode = listNode;
        }

        @Override
        public boolean hasNext() {
            return listNode != null;
        }

        @Override
        public Integer next() {
            var res = listNode.val;
            listNode = listNode.next;
            return res;
        }
    }
}
