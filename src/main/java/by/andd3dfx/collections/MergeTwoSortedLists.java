package by.andd3dfx.collections;

import java.util.Iterator;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Task description</a>
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * Example 1:
 * <img src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg"/>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * </pre>
 *
 * @see <a href="https://youtu.be/_jj1zgf0FBM">Video solution</a>
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists_usingIterators(ListNode list1, ListNode list2) {
        var head = new ListNode();
        var iterator1 = new MyIterator(list1);
        var iterator2 = new MyIterator(list2);

        var curr = head;
        while (iterator1.hasNext() && iterator2.hasNext()) {
            if (iterator1.peek() < iterator2.peek()) {
                curr.next = new ListNode(iterator1.next());
            } else {
                curr.next = new ListNode(iterator2.next());
            }
            curr = curr.next;
        }
        while (iterator1.hasNext()) {
            curr.next = new ListNode(iterator1.next());
            curr = curr.next;
        }
        while (iterator2.hasNext()) {
            curr.next = new ListNode(iterator2.next());
            curr = curr.next;
        }

        return head.next;
    }

    public static ListNode mergeTwoLists_usingRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists_usingRecursion(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists_usingRecursion(list1, list2.next);
            return list2;
        }
    }

    public static class MyIterator implements Iterator<Integer> {

        private ListNode curr;

        public MyIterator(ListNode head) {
            this.curr = head;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Integer next() {
            Integer res = curr.val;
            curr = curr.next;
            return res;
        }

        public Integer peek() {
            return curr.val;
        }
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
}
