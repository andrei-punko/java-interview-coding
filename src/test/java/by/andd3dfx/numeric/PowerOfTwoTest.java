package by.andd3dfx.numeric;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerOfTwoTest {

    @Test
    public void testIsPowerOfTwo() {
        assertTrue(PowerOfTwo.isPowerOfTwo(2));
        assertTrue(PowerOfTwo.isPowerOfTwo(1));
        assertFalse(PowerOfTwo.isPowerOfTwo(0));
        assertFalse(PowerOfTwo.isPowerOfTwo(-1));
        assertTrue(PowerOfTwo.isPowerOfTwo(32));
        assertFalse(PowerOfTwo.isPowerOfTwo(45));
    }
}