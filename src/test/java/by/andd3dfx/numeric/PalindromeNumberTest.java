package by.andd3dfx.numeric;

import static by.andd3dfx.numeric.PalindromeNumber.isPalindrome;
import static by.andd3dfx.numeric.PalindromeNumber.isPalindrome2;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PalindromeNumberTest {

    @Test
    public void testIsPalindrome() {
        assertThat(isPalindrome(121)).isTrue();
        assertThat(isPalindrome(1568651)).isTrue();
        assertThat(isPalindrome(-121)).isFalse();
        assertThat(isPalindrome(10)).isFalse();
        assertThat(isPalindrome(123)).isFalse();
        assertThat(isPalindrome(1001)).isTrue();
        assertThat(isPalindrome(0)).isTrue();
    }

    @Test
    public void testIsPalindrome2() {
        assertThat(isPalindrome2(121)).isTrue();
        assertThat(isPalindrome2(1568651)).isTrue();
        assertThat(isPalindrome2(-121)).isFalse();
        assertThat(isPalindrome2(10)).isFalse();
        assertThat(isPalindrome2(123)).isFalse();
        assertThat(isPalindrome2(1001)).isTrue();
        assertThat(isPalindrome2(0)).isTrue();
    }
}
