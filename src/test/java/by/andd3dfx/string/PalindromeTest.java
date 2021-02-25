package by.andd3dfx.string;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class PalindromeTest {

  @Test
  public void isPalindrome() {
    assertThat("ertglgtre is palindrom", Palindrome.isPalindrome("ertglgtre"), is(true));
    assertThat("Anna is palindrom (case insensitive)", Palindrome.isPalindrome("Anna"), is(true));
    assertThat("Dumb is not palindrom", Palindrome.isPalindrome("Dumb"), is(false));
  }

  @Test
  public void removePalindromesFromString() {
    assertThat(Palindrome.removePalindromesFromString("assa Rome, Anna all liquid small mom"), is(" Rome,  all liquid small "));
  }

  @Test
  public void removeNthPalindrome() {
    assertThat("Second palindrome should be removed",
        Palindrome.removeNthPalindrome("All assa Rome Anna small mom", 2), is("All assa Rome  small mom"));
    assertThat("String should should not be changed",
        Palindrome.removeNthPalindrome("All assa Rome Anna small mom", 5), is("All assa Rome Anna small mom"));
  }
}
