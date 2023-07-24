package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.ValidNumber.isNumber;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidNumberTest {

    @Test
    public void testIsNumber() {
        assertTrue(isNumber("2"));
        assertTrue(isNumber("0089"));
        assertTrue(isNumber("-0.1"));
        assertTrue(isNumber("+3.14"));
        assertTrue(isNumber("4."));
        assertTrue(isNumber("-.9"));
        assertTrue(isNumber("2e10"));
        assertTrue(isNumber("-90E3"));
        assertTrue(isNumber("3e+7"));
        assertTrue(isNumber("+6e-1"));
        assertTrue(isNumber("53.5e93"));
        assertTrue(isNumber("-123.456e789"));

        assertFalse(isNumber("abc"));
        assertFalse(isNumber("1a"));
        assertFalse(isNumber("1e"));
        assertFalse(isNumber("e3"));
        assertFalse(isNumber("99e2.5"));
        assertFalse(isNumber("--6"));
        assertFalse(isNumber("-+3"));
        assertFalse(isNumber("95a54e53"));
    }
}