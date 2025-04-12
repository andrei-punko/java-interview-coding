package by.andd3dfx.string;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static by.andd3dfx.string.Palindrome.canFormPalindrome;
import static by.andd3dfx.string.Palindrome.isPalindrome;
import static by.andd3dfx.string.Palindrome.isPalindromeIgnoreCase;
import static by.andd3dfx.string.Palindrome.longestPalindromeSubstring;
import static by.andd3dfx.string.Palindrome.removeNthPalindrome;
import static by.andd3dfx.string.Palindrome.removePalindromes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeTest {

  @Test
  public void testIsPalindrome() {
    assertThat(isPalindrome("ertglgtre")).isEqualTo(true);
    assertThat(isPalindrome("Anna")).isEqualTo(false);
    assertThat(isPalindrome("anna")).isEqualTo(true);
    assertThat(isPalindrome("Dumb")).isEqualTo(false);
  }

  @Test
  public void testIsPalindromeIgnoreCase() {
    assertThat(isPalindromeIgnoreCase("ertglgtre")).isEqualTo(true);
    assertThat(isPalindromeIgnoreCase("Anna")).isEqualTo(true);
    assertThat(isPalindromeIgnoreCase("Dumb")).isEqualTo(false);
  }

  @Test
  public void testRemovePalindromes() {
    assertThat(removePalindromes("assa Rome Anna all liquid small mom")).isEqualTo("Rome all liquid small");
    assertThat(removePalindromes("assa Rome, Anna, all liquid small mom")).isEqualTo("Rome, all liquid small");
  }

  @Test
  public void testRemoveNthPalindrome() {
    assertThat(removeNthPalindrome("All assa Rome Anna small mom", 2))
            .as("Second palindrome should be removed")
            .isEqualTo("All assa Rome small mom");
    assertThat(removeNthPalindrome("All assa Rome Anna small mom", 5))
            .as("String should should not be changed")
            .isEqualTo("All assa Rome Anna small mom");

    assertThat(removeNthPalindrome("All assa Rome, Anna, small mom", 2))
            .as("Second palindrome should be removed")
            .isEqualTo("All assa Rome, small mom");
    assertThat(removeNthPalindrome("All assa Rome, Anna, small mom", 5))
            .as("String should should not be changed")
            .isEqualTo("All assa Rome, Anna, small mom");
  }

  @Test
  public void testLongestPalindromeSubstring() {
    assertThat(longestPalindromeSubstring("forgeeksskeegfor")).isEqualTo("geeksskeeg");
    assertThat(longestPalindromeSubstring("Geeks")).isEqualTo("ee");
    assertThat(longestPalindromeSubstring("Composition")).isEqualTo("iti");
    assertThat(longestPalindromeSubstring("abbaerrtrre1ll1")).isEqualTo("errtrre");
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
