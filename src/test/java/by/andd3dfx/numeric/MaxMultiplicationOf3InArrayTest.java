package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.MaxMultiplicationOf3InArray.find;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaxMultiplicationOf3InArrayTest {

    @Test(expected = IllegalArgumentException.class)
    public void findWhenEmptyArray() {
        find(new int[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void findWhenLessThan3ElementsInArray() {
        find(new int[]{2, 9});
    }

    @Test
    public void testFind() {
        assertThat("All positive", find(new int[]{1, 4, 3, 8, 1}), is(96L));
        assertThat("One negative", find(new int[]{1, -3, 4, 8, 2}), is(64L));
        assertThat("Two negative", find(new int[]{-1, 3, 4, -2, 1}), is(12L));
        assertThat("All negative", find(new int[]{-1, -3, -4, -2, -1}), is(-2L));
    }
}
