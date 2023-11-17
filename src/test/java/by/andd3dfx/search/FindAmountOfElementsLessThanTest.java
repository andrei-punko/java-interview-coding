package by.andd3dfx.search;

import org.junit.Test;

import static by.andd3dfx.search.FindAmountOfElementsLessThan.usingBinarySearch;
import static by.andd3dfx.search.FindAmountOfElementsLessThan.usingInterpolationSearch;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FindAmountOfElementsLessThanTest {

    @Test
    public void testUsingBinarySearch() {
        assertThat("array doesn't contain target item",
                usingBinarySearch(new int[]{1, 2, 3, 5, 7}, 4), is(3));
        assertThat("array contains target item",
                usingBinarySearch(new int[]{1, 3, 4, 4, 5, 7}, 4), is(2));
        assertThat("all items are greater than target item",
                usingBinarySearch(new int[]{5, 6, 7, 8}, 4), is(0));
        assertThat("all items are less than target item",
                usingBinarySearch(new int[]{1, 2, 3, 3}, 4), is(4));
    }

    @Test
    public void testUsingInterpolationSearch() {
        assertThat("array doesn't contain target item",
                usingInterpolationSearch(new int[]{1, 2, 3, 5, 7}, 4), is(3));
        assertThat("array contains target item",
                usingInterpolationSearch(new int[]{1, 3, 4, 4, 5, 7}, 4), is(2));
        assertThat("all items are greater than target item",
                usingInterpolationSearch(new int[]{5, 6, 7, 8}, 4), is(0));
        assertThat("all items are less than target item",
                usingInterpolationSearch(new int[]{1, 2, 3, 3}, 4), is(4));
    }
}
