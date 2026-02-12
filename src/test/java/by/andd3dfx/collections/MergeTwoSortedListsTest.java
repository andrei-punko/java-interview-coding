package by.andd3dfx.collections;

import static org.assertj.core.api.Assertions.assertThat;

import by.andd3dfx.collections.MergeTwoSortedLists.ListNode;
import java.util.function.BiFunction;
import org.junit.Test;

public class MergeTwoSortedListsTest {

    @Test
    public void testMergeTwoListsUsingIterators() {
        testMergeOfTwoList(MergeTwoSortedLists::mergeTwoLists_usingIterators);
    }

    @Test
    public void testMergeTwoListsUsingRecursion() {
        testMergeOfTwoList(MergeTwoSortedLists::mergeTwoLists_usingRecursion);
    }

    public void testMergeOfTwoList(BiFunction<ListNode, ListNode, ListNode> function) {
        assertThat(function.apply(null, null))
            .isEqualTo(null);
        assertThat(function.apply(null, new ListNode(0)))
            .isEqualTo(new ListNode(0));

        assertThat(function.apply(
            new ListNode(1, new ListNode(2, new ListNode(4))),
            new ListNode(1, new ListNode(3, new ListNode(4)))
        )).isEqualTo(
            new ListNode(1,
                new ListNode(1,
                    new ListNode(2,
                        new ListNode(3,
                            new ListNode(4,
                                new ListNode(4))))))
        );

        assertThat(function.apply(
            new ListNode(3, new ListNode(7, new ListNode(90))),
            new ListNode(1, new ListNode(4, new ListNode(78, new ListNode(98))))
        )).isEqualTo(
            new ListNode(1,
                new ListNode(3,
                    new ListNode(4,
                        new ListNode(7,
                            new ListNode(78,
                                new ListNode(90,
                                    new ListNode(98)))))))
        );
    }
}
