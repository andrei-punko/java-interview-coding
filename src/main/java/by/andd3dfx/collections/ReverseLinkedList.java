package by.andd3dfx.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/reverse-linked-list/">Task description</a>
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 * <img src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg"/>
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Example 2:
 * <img src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg"/>
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Example 3:
 * Input: head = []
 * Output: []
 * </pre>
 *
 * @see <a href="https://youtu.be/iEKdRgKNurg">Video solution</a>
 */
public class ReverseLinkedList {

    @Data
    @AllArgsConstructor
    public static class Node<T> {

        private T value;
        private Node next;

        @Override
        public String toString() {
            return "Node{v=%s}".formatted(value);
        }
    }

    public static Node reverseUsingLoop(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public static Node reverseUsingStack(Node head) {
        Deque<Node> stack = new ArrayDeque<>();
        Node curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        Node result = stack.peek();

        curr = result;
        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
            curr.next = null;
        }

        return result;
    }

    public static Node reverseUsingRecursion(Node head) {
        return recursion(null, head);
    }

    private static Node recursion(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }
        Node next = curr.next;
        curr.next = prev;
        return recursion(curr, next);
    }
}
