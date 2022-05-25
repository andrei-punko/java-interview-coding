package by.andd3dfx.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LongestPalindromeSubstringTest {

    @Test
    public void longestPalindromeSubstring() {
        assertThat(LongestPalindromeSubstring.find("forgeeksskeegfor")).isEqualTo("geeksskeeg");
        assertThat(LongestPalindromeSubstring.find("Geeks")).isEqualTo("ee");
        assertThat(LongestPalindromeSubstring.find("Composition")).isEqualTo("iti");
        assertThat(LongestPalindromeSubstring.find("abbaerrtrre1ll1")).isEqualTo("errtrre");
    }

    @Test
    public void checkIsPalindrome() {
        assertThat(LongestPalindromeSubstring.checkIsPalindrome("abba")).isEqualTo(true);
        assertThat(LongestPalindromeSubstring.checkIsPalindrome("madam")).isEqualTo(true);
        assertThat(LongestPalindromeSubstring.checkIsPalindrome("Andrei")).isEqualTo(false);
    }
}