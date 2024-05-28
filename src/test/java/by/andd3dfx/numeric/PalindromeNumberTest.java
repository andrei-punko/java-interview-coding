package by.andd3dfx.numeric;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeNumberTest {

    private PalindromeNumber palindromeNumber;

    @Before
    public void setUp() throws Exception {
        palindromeNumber = new PalindromeNumber();
    }

    @Test
    public void isPalindrome() {
        assertTrue(palindromeNumber.isPalindrome(121));
        assertTrue(palindromeNumber.isPalindrome(1568651));
        assertFalse(palindromeNumber.isPalindrome(-121));
        assertFalse(palindromeNumber.isPalindrome(123));
        assertFalse(palindromeNumber.isPalindrome(10));
        assertTrue(palindromeNumber.isPalindrome(0));
    }
}
