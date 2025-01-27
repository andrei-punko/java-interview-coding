package by.andd3dfx.collections;

import by.andd3dfx.collections.LoopInLinkedList.Node;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoopInLinkedListTest {

    @Test
    public void findForSingleNode() {
        Node head = new Node(10);

        assertFalse(LoopInLinkedList.isPresent(head));
    }

    @Test
    public void find() {
        Node head = new Node(10, new Node(12, new Node(13)));

        assertFalse(LoopInLinkedList.isPresent(head));
    }

    @Test
    public void findForListWithOddLengthLoop() {
        Node node1 = new Node(10);
        Node node2 = new Node(11, node1);
        Node node3 = new Node(12, node2);
        Node node4 = new Node(13, node3);
        Node node5 = new Node(14, node4);
        node1.setNext(node3);

        assertTrue(LoopInLinkedList.isPresent(node5));
        assertTrue(LoopInLinkedList.isPresent(node4));
        assertTrue(LoopInLinkedList.isPresent(node3));
        assertTrue(LoopInLinkedList.isPresent(node2));
        assertTrue(LoopInLinkedList.isPresent(node1));
    }

    @Test
    public void findForListWithEvenLengthLoop() {
        Node node1 = new Node(10);
        Node node2 = new Node(11, node1);
        Node node3 = new Node(12, node2);
        Node node4 = new Node(13, node3);
        Node node5 = new Node(14, node4);
        node1.setNext(node4);

        assertTrue(LoopInLinkedList.isPresent(node5));
        assertTrue(LoopInLinkedList.isPresent(node4));
        assertTrue(LoopInLinkedList.isPresent(node3));
        assertTrue(LoopInLinkedList.isPresent(node2));
        assertTrue(LoopInLinkedList.isPresent(node1));
    }

    @Test
    public void findForSingleNodeWithLoop() {
        Node head = new Node(10);
        head.setNext(head);

        assertTrue(LoopInLinkedList.isPresent(head));
    }
}
