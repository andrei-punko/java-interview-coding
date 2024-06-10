package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.PalindromeNumber.isPalindrome;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeNumberTest {

    @Test
    public void testIsPalindrome() {
        assertTrue(isPalindrome(121));
        assertTrue(isPalindrome(1568651));
        assertFalse(isPalindrome(-121));
        assertFalse(isPalindrome(123));
        assertFalse(isPalindrome(10));
        assertTrue(isPalindrome(0));
    }
}
