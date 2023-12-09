package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.PowerOfK.isPowerOfK;
import static by.andd3dfx.numeric.PowerOfK.isPowerOfK_usingLog;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PowerOfKTest {

    @Test
    public void testIsPowerOfK() {
        assertTrue(isPowerOfK(2, 2));
        assertTrue(isPowerOfK(3, 3));

        assertTrue(isPowerOfK(1, 2));
        assertTrue(isPowerOfK(1, 3));

        assertFalse(isPowerOfK(0, 2));
        assertFalse(isPowerOfK(0, 3));

        assertFalse(isPowerOfK(-1, 2));
        assertFalse(isPowerOfK(-1, 3));

        assertTrue(isPowerOfK(16, 2));
        assertTrue(isPowerOfK(27, 3));

        assertFalse(isPowerOfK(34, 2));
        assertFalse(isPowerOfK(45, 3));
    }

    @Test
    public void testIsPowerOfK_usingLog() {
        assertTrue(isPowerOfK_usingLog(2, 2));
        assertTrue(isPowerOfK_usingLog(3, 3));

        assertTrue(isPowerOfK_usingLog(1, 2));
        assertTrue(isPowerOfK_usingLog(1, 3));

        assertFalse(isPowerOfK_usingLog(0, 2));
        assertFalse(isPowerOfK_usingLog(0, 3));

        assertFalse(isPowerOfK_usingLog(-1, 2));
        assertFalse(isPowerOfK_usingLog(-1, 3));

        assertTrue(isPowerOfK_usingLog(16, 2));
        assertTrue(isPowerOfK_usingLog(27, 3));

        assertFalse(isPowerOfK_usingLog(34, 2));
        assertFalse(isPowerOfK_usingLog(45, 3));
    }
}
