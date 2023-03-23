package by.andd3dfx.search;

import org.junit.Test;

import static by.andd3dfx.search.FindElementsOfArrayWhichNotPresentInAnotherArray.find;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FindElementsOfArrayWhichNotPresentInAnotherArrayTest {

    @Test
    public void findUsual() {
        assertThat(find(new Integer[]{-1, 2, 2, 5, 7}, new Integer[]{2, 5, 8, 8, 8}), is(new Integer[]{-1, 7}));
    }

    @Test
    public void findWhenMultipleRepeatableElementsInFirstArrayWhichNotPresentInSecondArray() {
        assertThat(find(new Integer[]{-1, -1, 0, 1, 2, 4, 4}, new Integer[]{-1, 0, 2}), is(new Integer[]{1, 4, 4}));
    }

    @Test
    public void findWhenSameArrays() {
        assertThat(find(new Integer[]{-1, 2, 3}, new Integer[]{-1, 2, 3}), is(new Integer[]{}));
    }

    @Test
    public void findWhenFirstArrayIsEmpty() {
        assertThat(find(new Integer[]{}, new Integer[]{-1, 2, 3}), is(new Integer[]{}));
    }
}
