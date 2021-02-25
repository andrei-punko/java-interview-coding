package by.andd3dfx.interview.train2021;

import by.andd3dfx.interview.train2021.CompactLinkedList.Node;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CompactLinkedListTest {

    @Test
    public void reverse() {
        CompactLinkedList<Integer> linkedList = buildLinkedList();
        checkSourceList(linkedList);

        linkedList.reverse();
        checkReversedList(linkedList);
    }

    @Test
    public void reverseRecursive() {
        CompactLinkedList<Integer> linkedList = buildLinkedList();
        checkSourceList(linkedList);

        linkedList.recursiveReverse();
        checkReversedList(linkedList);
    }

    private CompactLinkedList<Integer> buildLinkedList() {
        Node head = new Node(3, new Node(7, new Node(12, new Node(10, null))));
        return (CompactLinkedList<Integer>) new CompactLinkedList(head);
    }

    private void checkSourceList(CompactLinkedList<Integer> linkedList) {
        assertThat("Wrong 0 item of source list", linkedList.head.value, is(3));
        assertThat("Wrong 1 item of source list", linkedList.head.next.value, is(7));
        assertThat("Wrong 2 item of source list", linkedList.head.next.next.value, is(12));
        assertThat("Wrong 3 item of source list", linkedList.head.next.next.next.value, is(10));
    }

    private void checkReversedList(CompactLinkedList<Integer> linkedList) {
        assertThat("Wrong 0 item of reversed list", linkedList.head.value, is(10));
        assertThat("Wrong 1 item of reversed list", linkedList.head.next.value, is(12));
        assertThat("Wrong 2 item of reversed list", linkedList.head.next.next.value, is(7));
        assertThat("Wrong 3 item of reversed list", linkedList.head.next.next.next.value, is(3));
    }
}
