package by.andd3dfx.search;

import org.junit.Test;

import static by.andd3dfx.search.FindElementsOfArrayWhichNotPresentInAnotherArray.find;
import static org.assertj.core.api.Assertions.assertThat;

public class FindElementsOfArrayWhichNotPresentInAnotherArrayTest {

    @Test
    public void findUsual() {
        assertThat(find(new Integer[]{-1, 2, 2, 5, 7}, new Integer[]{2, 5, 8, 8, 8}))
            .isEqualTo(new Integer[]{-1, 7});
    }

    @Test
    public void findWhenMultipleRepeatableElementsInFirstArrayWhichNotPresentInSecondArray() {
        assertThat(find(new Integer[]{-1, -1, 0, 1, 2, 4, 4}, new Integer[]{-1, 0, 2}))
            .isEqualTo(new Integer[]{1, 4, 4});
    }

    @Test
    public void findWhenSameArrays() {
        assertThat(find(new Integer[]{-1, 2, 3}, new Integer[]{-1, 2, 3}))
            .isEqualTo(new Integer[]{});
    }

    @Test
    public void findWhenFirstArrayIsEmpty() {
        assertThat(find(new Integer[]{}, new Integer[]{-1, 2, 3}))
            .isEqualTo(new Integer[]{});
    }
}
