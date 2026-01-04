package by.andd3dfx.collections;

import static org.assertj.core.api.Assertions.assertThat;

import by.andd3dfx.collections.RemoveNthNodeFromLinkedListEnd.ListNode;
import org.junit.Test;

public class RemoveNthNodeFromLinkedListEndTest {

    @Test
    public void removeNthFromEnd1() {
        var head = new ListNode(1,
            new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        var result = RemoveNthNodeFromLinkedListEnd.removeNthFromEnd(head, 2);

        assertThat(result.val).isEqualTo(1);
        assertThat(result.next.val).isEqualTo(2);
        assertThat(result.next.next.val).isEqualTo(3);
        assertThat(result.next.next.next.val).isEqualTo(5);
        assertThat(result.next.next.next.next).isNull();
    }

    @Test
    public void removeNthFromEnd2() {
        var head = new ListNode(1);

        var result = RemoveNthNodeFromLinkedListEnd.removeNthFromEnd(head, 1);

        assertThat(result).isNull();
    }

    @Test
    public void removeNthFromEnd3() {
        var head = new ListNode(1, new ListNode(2));

        var result = RemoveNthNodeFromLinkedListEnd.removeNthFromEnd(head, 1);

        assertThat(result.val).isEqualTo(1);
        assertThat(result.next).isNull();
    }
}
