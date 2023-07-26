package by.andd3dfx.collections;

import by.andd3dfx.collections.RotateLinkedList.ListNode;
import org.junit.Test;

import static by.andd3dfx.collections.RotateLinkedList.rotateLeft;
import static by.andd3dfx.collections.RotateLinkedList.rotateRight;
import static org.assertj.core.api.Assertions.assertThat;

public class RotateLinkedListTest {

    @Test
    public void rotateRight_whenHeadIsNull() {
        assertThat(rotateRight(null, 2)).isNull();
    }

    @Test
    public void rotateLeft_whenHeadIsNull() {
        assertThat(rotateLeft(null, 2)).isNull();
    }

    @Test
    public void rotateRight_whenJustShiftNeeded() {
        var result = rotateRight(buildLinkedList(new int[]{1, 2, 3, 4, 5}), 2);

        checkLinkedListContent(result, new int[]{4, 5, 1, 2, 3});
    }

    @Test
    public void rotateLeft_whenJustShiftNeeded() {
        var result = rotateLeft(buildLinkedList(new int[]{1, 2, 3, 4, 5}), 2);

        checkLinkedListContent(result, new int[]{3, 4, 5, 1, 2});
    }

    @Test
    public void rotateRight_whenJustShiftNeeded2() {
        var result2 = rotateRight(buildLinkedList(new int[]{1, 2}), 1);

        checkLinkedListContent(result2, new int[]{2, 1});
    }

    @Test
    public void rotateLeft_whenJustShiftNeeded2() {
        var result2 = rotateLeft(buildLinkedList(new int[]{1, 2}), 1);

        checkLinkedListContent(result2, new int[]{2, 1});
    }

    @Test
    public void rotateRight_whenShiftGreaterThanArraySize() {
        var result = rotateRight(buildLinkedList(new int[]{0, 1, 2}), 4);

        checkLinkedListContent(result, new int[]{2, 0, 1});
    }

    @Test
    public void rotateLeft_whenShiftGreaterThanArraySize() {
        var result = rotateLeft(buildLinkedList(new int[]{0, 1, 2}), 4);

        checkLinkedListContent(result, new int[]{1, 2, 0});
    }

    @Test
    public void rotateRight_whenShiftGreaterThanArraySizeButEqualsToIntAmountOfSizes() {
        var result = rotateRight(buildLinkedList(new int[]{0, 1, 2}), 6);

        checkLinkedListContent(result, new int[]{0, 1, 2});
    }

    @Test
    public void rotateLeft_whenShiftGreaterThanArraySizeButEqualsToIntAmountOfSizes() {
        var result = rotateLeft(buildLinkedList(new int[]{0, 1, 2}), 6);

        checkLinkedListContent(result, new int[]{0, 1, 2});
    }

    @Test
    public void rotateRight_whenShiftLengthIsZero() {
        var result = rotateRight(buildLinkedList(new int[]{0, 1, 2}), 0);

        checkLinkedListContent(result, new int[]{0, 1, 2});
    }

    @Test
    public void rotateLeft_whenShiftLengthIsZero() {
        var result = rotateLeft(buildLinkedList(new int[]{0, 1, 2}), 0);

        checkLinkedListContent(result, new int[]{0, 1, 2});
    }

    private ListNode buildLinkedList(int[] values) {
        ListNode next = null;
        for (int i = values.length - 1; i >= 0; i--) {
            next = new ListNode(values[i], next);
        }
        return next;
    }

    private void checkLinkedListContent(ListNode head, int[] expected) {
        int i = 0;
        while (head.getNext() != null) {
            assertThat(head.getVal()).isEqualTo(expected[i]);

            head = head.getNext();
            i++;
        }
        assertThat(i).isEqualTo(expected.length - 1);
    }
}
