package by.andd3dfx.search;

import org.junit.Test;

import static by.andd3dfx.search.FindAmountOfElementsLessThan.usingBinarySearch;
import static by.andd3dfx.search.FindAmountOfElementsLessThan.usingInterpolationSearch;
import static by.andd3dfx.search.FindAmountOfElementsLessThan.usingPrimitiveIteration;
import static org.assertj.core.api.Assertions.assertThat;

public class FindAmountOfElementsLessThanTest {

    @Test
    public void testUsingPrimitiveIteration() {
        assertThat(usingPrimitiveIteration(new int[]{1, 2, 3, 5, 7}, 4))
            .as("When array doesn't contain target item")
            .isEqualTo(3);
        assertThat(usingPrimitiveIteration(new int[]{1, 3, 4, 4, 5, 7}, 4))
            .as("When array contains target item")
            .isEqualTo(2);
        assertThat(usingPrimitiveIteration(new int[]{5, 6, 7, 8}, 4))
            .as("When all items are greater than target item")
            .isEqualTo(0);
        assertThat(usingPrimitiveIteration(new int[]{1, 2, 3, 3}, 4))
            .as("When all items are less than target item")
            .isEqualTo(4);
    }

    @Test
    public void testUsingBinarySearch() {
        assertThat(usingBinarySearch(new int[]{1, 2, 3, 5, 7}, 4))
            .as("When array doesn't contain target item")
            .isEqualTo(3);
        assertThat(usingBinarySearch(new int[]{1, 3, 4, 4, 5, 7}, 4))
            .as("When array contains target item")
            .isEqualTo(2);
        assertThat(usingBinarySearch(new int[]{5, 6, 7, 8}, 4))
            .as("When all items are greater than target item")
            .isEqualTo(0);
        assertThat(usingBinarySearch(new int[]{1, 2, 3, 3}, 4))
            .as("When all items are less than target item")
            .isEqualTo(4);
    }

    @Test
    public void testUsingInterpolationSearch() {
        assertThat(usingInterpolationSearch(new int[]{1, 2, 3, 5, 7}, 4))
            .as("When array doesn't contain target item")
            .isEqualTo(3);
        assertThat(usingInterpolationSearch(new int[]{1, 3, 4, 4, 5, 7}, 4))
            .as("When array contains target item")
            .isEqualTo(2);
        assertThat(usingInterpolationSearch(new int[]{5, 6, 7, 8}, 4))
            .as("When all items are greater than target item")
            .isEqualTo(0);
        assertThat(usingInterpolationSearch(new int[]{1, 2, 3, 3}, 4))
            .as("When all items are less than target item")
            .isEqualTo(4);
    }
}
