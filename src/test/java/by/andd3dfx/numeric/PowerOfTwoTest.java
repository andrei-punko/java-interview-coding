package by.andd3dfx.numeric;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PowerOfTwoTest {

    @Test
    public void testIsPowerOfTwo() {
        assertTrue(PowerOfTwo.isPowerOfTwo(2));
        assertTrue(PowerOfTwo.isPowerOfTwo(1));
        assertFalse(PowerOfTwo.isPowerOfTwo(0));
        assertFalse(PowerOfTwo.isPowerOfTwo(-1));
        assertTrue(PowerOfTwo.isPowerOfTwo(16));
        assertFalse(PowerOfTwo.isPowerOfTwo(34));
    }

    @Test
    public void testIsPowerOfTwo_usingLog() {
        assertTrue(PowerOfTwo.isPowerOfTwo_usingLog(2));
        assertTrue(PowerOfTwo.isPowerOfTwo_usingLog(1));
        assertFalse(PowerOfTwo.isPowerOfTwo_usingLog(0));
        assertFalse(PowerOfTwo.isPowerOfTwo_usingLog(-1));
        assertTrue(PowerOfTwo.isPowerOfTwo_usingLog(16));
        assertFalse(PowerOfTwo.isPowerOfTwo_usingLog(34));
    }
}