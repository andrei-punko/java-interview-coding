package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.DoorNBox.couldPass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DoorNBoxTest {

    @Test
    public void testCouldPass() {
        assertTrue(couldPass(new int[]{3, 2, 1}, new int[]{2, 1}));
        assertTrue(couldPass(new int[]{17, 9, 11}, new int[]{14, 9}));
        assertTrue(couldPass(new int[]{100, 0, 7}, new int[]{8, 1}));

        assertFalse(couldPass(new int[]{10, 11, 12}, new int[]{10, 10}));
        assertFalse(couldPass(new int[]{7, 7, 12}, new int[]{6, 20}));
    }
}
