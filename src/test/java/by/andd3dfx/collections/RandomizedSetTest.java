package by.andd3dfx.collections;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RandomizedSetTest {

    private RandomizedSet randomizedSet;

    @Before
    public void setUp() throws Exception {
        randomizedSet = new RandomizedSet();
    }

    @Test
    public void insert() {
        RandomizedSet randomizedSet = new RandomizedSet();
        assertTrue(randomizedSet.insert(1));        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        assertFalse(randomizedSet.remove(2));       // Returns false as 2 does not exist in the set.
        assertTrue(randomizedSet.insert(2));        // Inserts 2 to the set, returns true. Set now contains [1,2].
        assertThat(randomizedSet.getRandom()).isIn(1, 2);       // getRandom() should return either 1 or 2 randomly.
        assertTrue(randomizedSet.remove(1));        // Removes 1 from the set, returns true. Set now contains [2].
        assertFalse(randomizedSet.insert(2));       // 2 was already in the set, so return false.
        assertThat(randomizedSet.getRandom()).isEqualTo(2);    // Since 2 is the only number in the set, getRandom() will always return 2.
    }
}
