package by.andd3dfx.search;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class BinarySearchTest {

    @Test
    public void perform() {
        Assert.assertThat(BinarySearch.perform(new int[]{1, 2, 3, 4, 5}, 4), is(3));
        Assert.assertThat(BinarySearch.perform(new int[]{1, 2, 2, 3, 4, 8}, 2), is(1));
        Assert.assertThat(BinarySearch.perform(new int[]{-2, -1, 1, 2, 5, 8, 9, 12, 15}, 12), is(7));
    }

    @Test
    public void performWhenNothingFound() {
        Assert.assertThat(BinarySearch.perform(new int[]{1, 2, 3, 4, 5}, 41), is(-1));
    }
}
