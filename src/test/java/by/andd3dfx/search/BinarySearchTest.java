package by.andd3dfx.search;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinarySearchTest {

    @Test
    public void perform() {
        assertThat(BinarySearch.perform(new int[]{1, 2, 3, 4, 5}, 4), is(3));
        assertThat(BinarySearch.perform(new int[]{1, 2, 2, 3, 4, 8}, 2), is(1));
        assertThat(BinarySearch.perform(new int[]{-2, -1, 1, 2, 5, 8, 9, 12, 15}, 12), is(7));
    }

    @Test
    public void performWhenNothingFound() {
        assertThat(BinarySearch.perform(new int[]{1, 2, 3, 4, 5}, 41), is(-1));
    }
}
