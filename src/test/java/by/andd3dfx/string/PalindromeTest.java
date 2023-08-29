package by.andd3dfx.string;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static by.andd3dfx.string.Palindrome.canFormPalindrome;
import static by.andd3dfx.string.Palindrome.isPalindrome;
import static by.andd3dfx.string.Palindrome.isPalindromeIgnoreCase;
import static by.andd3dfx.string.Palindrome.longestPalindromeSubstring;
import static by.andd3dfx.string.Palindrome.removeNthPalindrome;
import static by.andd3dfx.string.Palindrome.removePalindromes;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeTest {

  @Test
  public void testIsPalindrome() {
    assertThat(isPalindrome("ertglgtre"), is(true));
    assertThat(isPalindrome("Anna"), is(false));
    assertThat(isPalindrome("anna"), is(true));
    assertThat(isPalindrome("Dumb"), is(false));
  }

  @Test
  public void testIsPalindromeIgnoreCase() {
    assertThat(isPalindromeIgnoreCase("ertglgtre"), is(true));
    assertThat(isPalindromeIgnoreCase("Anna"), is(true));
    assertThat(isPalindromeIgnoreCase("Dumb"), is(false));
  }

  @Test
  public void testRemovePalindromes() {
    assertThat(removePalindromes("assa Rome Anna all liquid small mom"), is("Rome all liquid small"));
    assertThat(removePalindromes("assa Rome, Anna, all liquid small mom"), is("Rome, all liquid small"));
  }

  @Test
  public void testRemoveNthPalindrome() {
    assertThat("Second palindrome should be removed",
        removeNthPalindrome("All assa Rome Anna small mom", 2), is("All assa Rome small mom"));
    assertThat("String should should not be changed",
        removeNthPalindrome("All assa Rome Anna small mom", 5), is("All assa Rome Anna small mom"));

    assertThat("Second palindrome should be removed",
            removeNthPalindrome("All assa Rome, Anna, small mom", 2), is("All assa Rome, small mom"));
    assertThat("String should should not be changed",
            removeNthPalindrome("All assa Rome, Anna, small mom", 5), is("All assa Rome, Anna, small mom"));
  }

  @Test
  public void testLongestPalindromeSubstring() {
    Assertions.assertThat(longestPalindromeSubstring("forgeeksskeegfor")).isEqualTo("geeksskeeg");
    Assertions.assertThat(longestPalindromeSubstring("Geeks")).isEqualTo("ee");
    Assertions.assertThat(longestPalindromeSubstring("Composition")).isEqualTo("iti");
    Assertions.assertThat(longestPalindromeSubstring("abbaerrtrre1ll1")).isEqualTo("errtrre");
  }

    @Test
    public void testCanFormPalindrome() {
      assertTrue(canFormPalindrome("aall"));
      assertTrue(canFormPalindrome("derpdepr"));
      assertTrue(canFormPalindrome(" 78 7hjk 8jk h"));

      assertFalse(canFormPalindrome("T-Rex - Ballrooms of Mars"));
      assertFalse(canFormPalindrome("123456"));
    }
}
