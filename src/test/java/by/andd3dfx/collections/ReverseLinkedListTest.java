package by.andd3dfx.collections;

import org.junit.Test;

import static by.andd3dfx.collections.ReverseLinkedList.Node;
import static by.andd3dfx.collections.ReverseLinkedList.reverseUsingLoop;
import static by.andd3dfx.collections.ReverseLinkedList.reverseUsingRecursion;
import static by.andd3dfx.collections.ReverseLinkedList.reverseUsingStack;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

public class ReverseLinkedListTest {

    @Test
    public void testReverseUsingLoop() {
        Node head = buildLinkedList();

        Node newHead = reverseUsingLoop(head);
        checkReversedList(newHead);
    }

    @Test
    public void testReverseUsingLoopForNull() {
        assertNull(reverseUsingLoop(null));
    }

    @Test
    public void testReverseUsingStack() {
        Node head = buildLinkedList();

        Node newHead = reverseUsingStack(head);
        checkReversedList(newHead);
    }

    @Test
    public void testReverseUsingStackForNull() {
        assertNull(reverseUsingStack(null));
    }

    @Test
    public void testReverseUsingRecursion() {
        Node head = buildLinkedList();

        Node newHead = reverseUsingRecursion(head);
        checkReversedList(newHead);
    }

    @Test
    public void testReverseUsingRecursionForNull() {
        assertNull(reverseUsingRecursion(null));
    }

    private Node<Integer> buildLinkedList() {
        return new Node<>(3, new Node<>(7, new Node<>(12, new Node<>(10, null))));
    }

    private void checkReversedList(Node head) {
        assertThat(head.getValue())
                .as("Wrong 0 item of reversed list").isEqualTo(10);
        assertThat(head.getNext().getValue())
                .as("Wrong 1 item of reversed list").isEqualTo(12);
        assertThat(head.getNext().getNext().getValue())
                .as("Wrong 2 item of reversed list").isEqualTo(7);
        assertThat(head.getNext().getNext().getNext().getValue())
                .as("Wrong 3 item of reversed list").isEqualTo(3);
        assertThat(head.getNext().getNext().getNext().getNext())
                .as("Wrong next of 3 item of reversed list").isNull();
    }
}