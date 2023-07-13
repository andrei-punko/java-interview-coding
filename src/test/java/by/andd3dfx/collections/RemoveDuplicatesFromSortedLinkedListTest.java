package by.andd3dfx.collections;

import by.andd3dfx.collections.RemoveDuplicatesFromSortedLinkedList.Node;
import org.junit.Test;

import static by.andd3dfx.collections.RemoveDuplicatesFromSortedLinkedList.remove;
import static org.assertj.core.api.Assertions.assertThat;

public class RemoveDuplicatesFromSortedLinkedListTest {

    @Test
    public void testRemoveForNull() {
        assertThat(remove(null)).isNull();
    }

    @Test
    public void testRemoveForSingleNode() {
        var result = remove(new Node(100));

        assertThat(result.getValue()).isEqualTo(100);
        assertThat(result.getNext()).isNull();
    }

    @Test
    public void testRemoveWhenNoDuplicates() {
        var head = buildLinkedList(new int[]{10, 11, 12, 14, 19});

        var result = remove(head);

        checkLinkedListContent(result, new int[]{10, 11, 12, 14, 19});
    }

    @Test
    public void testRemoveWhenDuplicatesOnly() {
        var head = buildLinkedList(new int[]{10, 10, 10, 10, 10});

        var result = remove(head);

        checkLinkedListContent(result, new int[]{10});
    }

    @Test
    public void testRemove() {
        var head = buildLinkedList(new int[]{1, 2, 3, 3, 4, 4, 5});

        var result = remove(head);

        checkLinkedListContent(result, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testRemoveWhenDuplicatesNearTheHead() {
        var head = buildLinkedList(new int[]{11, 11, 11, 12, 14, 14, 14, 19});

        var result = remove(head);

        checkLinkedListContent(result, new int[]{11, 12, 14, 19});
    }

    private Node buildLinkedList(int[] values) {
        Node next = null;
        for (int i = values.length - 1; i >= 0; i--) {
            next = new Node(values[i], next);
        }
        return next;
    }

    private void checkLinkedListContent(Node head, int[] expected) {
        int i = 0;
        while (head.getNext() != null) {
            assertThat(head.getValue()).isEqualTo(expected[i]);

            head = head.getNext();
            i++;
        }
        assertThat(i).isEqualTo(expected.length - 1);
    }
}
