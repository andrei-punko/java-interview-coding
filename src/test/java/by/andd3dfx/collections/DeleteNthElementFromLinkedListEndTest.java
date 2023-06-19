package by.andd3dfx.collections;

import by.andd3dfx.collections.DeleteNthElementFromLinkedListEnd.Node;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class DeleteNthElementFromLinkedListEndTest {

    @Test
    public void applyForN0() {
        Node head = buildLinkedList();

        DeleteNthElementFromLinkedListEnd.apply(head, 0);

        assertThat(head.getValue()).isEqualTo(10);
        assertThat(head.getNext().getValue()).isEqualTo(11);
        assertThat(head.getNext().getNext().getValue()).isEqualTo(12);
        assertThat(head.getNext().getNext().getNext().getValue()).isEqualTo(13);
        assertThat(head.getNext().getNext().getNext().getNext()).isNull();
    }

    @Test
    public void applyForN2() {
        Node head = buildLinkedList();

        DeleteNthElementFromLinkedListEnd.apply(head, 2);

        assertThat(head.getValue()).isEqualTo(10);
        assertThat(head.getNext().getValue()).isEqualTo(11);
        assertThat(head.getNext().getNext().getValue()).isEqualTo(13);
        assertThat(head.getNext().getNext().getNext().getValue()).isEqualTo(14);
        assertThat(head.getNext().getNext().getNext().getNext()).isNull();
    }

    @Test
    public void applyWhenNIsNegative() {
        Node head = buildLinkedList();

        assertThrows("n should be >=0!", IllegalArgumentException.class,
                () -> DeleteNthElementFromLinkedListEnd.apply(head, -1));
    }

    @Test
    public void applyWhenNGreaterThanListSize() {
        Node head = buildLinkedList();

        assertThrows("n should be less than list size!", IllegalArgumentException.class,
                () -> DeleteNthElementFromLinkedListEnd.apply(head, 5));
    }

    private Node buildLinkedList() {
        return new Node(10, new Node(11, new Node(12, new Node(13, new Node(14)))));
    }
}
