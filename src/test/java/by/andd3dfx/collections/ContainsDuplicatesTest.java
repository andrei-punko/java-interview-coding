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
    public void containsDuplicate() {
        assertTrue(containsDuplicates.containsDuplicate(new int[]{1, 2, 3, 1}));
        assertFalse(containsDuplicates.containsDuplicate(new int[]{1, 2, 3, 4}));
        assertTrue(containsDuplicates.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}
