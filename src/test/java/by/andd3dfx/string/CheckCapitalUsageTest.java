package by.andd3dfx.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckCapitalUsageTest {

    private CheckCapitalUsage checkCapitalUsage;

    @Before
    public void setUp() throws Exception {
        checkCapitalUsage = new CheckCapitalUsage();
    }

    @Test
    public void isCapitalUsedProperly() {
        assertTrue(checkCapitalUsage.isCapitalUsedProperly("a"));
        assertTrue(checkCapitalUsage.isCapitalUsedProperly("A"));
        assertTrue(checkCapitalUsage.isCapitalUsedProperly("USA"));
        assertTrue(checkCapitalUsage.isCapitalUsedProperly("Google"));
        assertTrue(checkCapitalUsage.isCapitalUsedProperly("leetcode"));
        assertFalse(checkCapitalUsage.isCapitalUsedProperly("FlaG"));
        assertFalse(checkCapitalUsage.isCapitalUsedProperly("flAg"));
    }

    @Test
    public void isCapitalUsedProperly_withRegex() {
        assertTrue(checkCapitalUsage.isCapitalUsedProperly_withRegex("a"));
        assertTrue(checkCapitalUsage.isCapitalUsedProperly_withRegex("A"));
        assertTrue(checkCapitalUsage.isCapitalUsedProperly_withRegex("USA"));
        assertTrue(checkCapitalUsage.isCapitalUsedProperly_withRegex("Google"));
        assertTrue(checkCapitalUsage.isCapitalUsedProperly_withRegex("leetcode"));
        assertFalse(checkCapitalUsage.isCapitalUsedProperly_withRegex("FlaG"));
        assertFalse(checkCapitalUsage.isCapitalUsedProperly_withRegex("flAg"));
    }
}
