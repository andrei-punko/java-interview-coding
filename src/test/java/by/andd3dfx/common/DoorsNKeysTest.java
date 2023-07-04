package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.DoorsNKeys.couldOpenAllDoors;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DoorsNKeysTest {

    @Test
    public void testCouldOpenAllDoors() {
        assertTrue(couldOpenAllDoors(new int[]{0, 1, 2}, 3));
        assertFalse(couldOpenAllDoors(new int[]{0, 3, 2}, 1));
        assertTrue(couldOpenAllDoors(new int[]{3, 1, 0}, 2));
        assertFalse(couldOpenAllDoors(new int[]{1, 3, 0}, 2));
    }
}
