package by.andd3dfx.collections;

import by.andd3dfx.collections.PalindromeLinkedList.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeLinkedListTest {

    PalindromeLinkedList palindromeLinkedList;

    @BeforeEach
    void setUp() {
        palindromeLinkedList = new PalindromeLinkedList();
    }

    @Test
    void isPalindromeWhenPalindrome() {
        assertThat(palindromeLinkedList.isPalindrome(
            new ListNode(1))
        ).isTrue();

        assertThat(palindromeLinkedList.isPalindrome(
            new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))))
        ).isTrue();

        assertThat(palindromeLinkedList.isPalindrome(
            new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1))))))
        ).isTrue();
    }

    @Test
    void isPalindromeWhenPalindromeWhenNot() {
        assertThat(palindromeLinkedList.isPalindrome(
            new ListNode(1, new ListNode(2)))
        ).isFalse();

        assertThat(palindromeLinkedList.isPalindrome(
            new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3)))))
        ).isFalse();
    }
}
