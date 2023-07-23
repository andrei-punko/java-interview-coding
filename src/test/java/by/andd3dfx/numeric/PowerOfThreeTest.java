package by.andd3dfx.numeric;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PowerOfThreeTest {

    @Test
    public void testIsPowerOfThree() {
        assertTrue(PowerOfThree.isPowerOfThree(3));
        assertTrue(PowerOfThree.isPowerOfThree(1));
        assertFalse(PowerOfThree.isPowerOfThree(0));
        assertFalse(PowerOfThree.isPowerOfThree(-1));
        assertTrue(PowerOfThree.isPowerOfThree(27));
        assertFalse(PowerOfThree.isPowerOfThree(45));
    }
}