package by.andd3dfx.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContainsDuplicatesTest {

    private ContainsDuplicates containsDuplicates;

    @Before
    public void setUp() throws Exception {
        containsDuplicates = new ContainsDuplicates();
    }

    @Test
    public void usingSet() {
        assertTrue(containsDuplicates.usingSet(new int[]{2, 1, 3, 1}));
        assertFalse(containsDuplicates.usingSet(new int[]{2, 1, 3, 56, 4}));
        assertTrue(containsDuplicates.usingSet(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    @Test
    public void usingSortWithEarlyReturn() {
        assertTrue(containsDuplicates.usingSortWithEarlyReturn(new int[]{2, 1, 3, 1}));
        assertFalse(containsDuplicates.usingSortWithEarlyReturn(new int[]{2, 1, 3, 56, 4}));
        assertTrue(containsDuplicates.usingSortWithEarlyReturn(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}
