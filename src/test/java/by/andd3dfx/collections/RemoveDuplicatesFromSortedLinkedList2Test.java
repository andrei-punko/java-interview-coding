package by.andd3dfx.collections;

import by.andd3dfx.collections.RemoveDuplicatesFromSortedLinkedList2.Node;
import org.junit.Test;

import static by.andd3dfx.collections.RemoveDuplicatesFromSortedLinkedList2.remove;
import static org.assertj.core.api.Assertions.assertThat;

public class RemoveDuplicatesFromSortedLinkedList2Test {

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
        Node head = new Node(10,
                new Node(11,
                        new Node(12,
                                new Node(14,
                                        new Node(19)
                                ))));

        var result = remove(head);

        assertThat(result.toString()).isEqualTo("10->11->12->14->19");
    }

    @Test
    public void testRemoveWhenDuplicatesOnly() {
        Node head = new Node(10, new Node(10, new Node(10, new Node(10, new Node(10)))));

        var result = remove(head);

        assertThat(result).isNull();
    }

    @Test
    public void testRemove() {
        Node head = new Node(10,
                new Node(11, new Node(11,
                        new Node(12,
                                new Node(14, new Node(14, new Node(14,
                                        new Node(19)
                                )))))));

        var result = remove(head);

        assertThat(result.toString()).isEqualTo("10->12->19");
    }

    @Test
    public void testRemoveWhenDuplicatesNearTheHead() {
        Node head = new Node(11, new Node(11, new Node(11,
                new Node(12,
                        new Node(14, new Node(14, new Node(14,
                                new Node(19)
                        )))))));

        var result = remove(head);

        assertThat(result.toString()).isEqualTo("12->19");
    }
}
