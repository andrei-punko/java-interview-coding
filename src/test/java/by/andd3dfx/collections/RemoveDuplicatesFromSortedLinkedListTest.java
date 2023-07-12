package by.andd3dfx.collections;

import by.andd3dfx.collections.RemoveDuplicatesFromSortedLinkedList.Node;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveDuplicatesFromSortedLinkedListTest {

    @Test
    public void testRemoveNorNull() {
        assertThat(RemoveDuplicatesFromSortedLinkedList.remove(null)).isNull();
    }

    @Test
    public void testRemoveNorSingleNode() {
        var result = RemoveDuplicatesFromSortedLinkedList.remove(new Node(100));

        assertThat(result.getValue()).isEqualTo(100);
        assertThat(result.getNext()).isNull();
    }

    @Test
    public void testRemove() {
        Node head = new Node(10,
                new Node(11, new Node(11,
                        new Node(12,
                                new Node(14, new Node(14, new Node(14,
                                        new Node(19))))))));

        var result = RemoveDuplicatesFromSortedLinkedList.remove(head);

        assertThat(result.toString()).isEqualTo("{10, n={11, n={12, n={14, n={19}}}}}");
    }
}
