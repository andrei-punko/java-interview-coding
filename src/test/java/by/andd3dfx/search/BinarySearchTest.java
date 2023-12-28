package by.andd3dfx.search;

import org.junit.Test;

import static by.andd3dfx.search.BinarySearch.perform;
import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {

    @Test
    public void testPerform() {
        assertThat(perform(new int[]{1, 3}, 1)).isEqualTo(0);
        assertThat(perform(new int[]{1, 3}, 3)).isEqualTo(1);
        assertThat(perform(new int[]{1, 2, 3, 4, 5}, 4)).isEqualTo(3);
        assertThat(perform(new int[]{1, 2, 2, 3, 4, 8}, 2)).isEqualTo(2);
        assertThat(perform(new int[]{-2, -1, 1, 2, 5, 8, 9, 12, 15}, 12)).isEqualTo(7);
    }

    @Test
    public void testPerformWhenNothingFound() {
        assertThat(perform(new int[]{1, 2, 3, 4, 5}, 41)).isEqualTo(-1);
        assertThat(perform(new int[]{1, 2, 30, 40, 50, 51}, 35)).isEqualTo(-1);
    }

    @Test
    public void testPerformForEmptyArray() {
        assertThat(perform(new int[]{}, 0)).isEqualTo(-1);
    }
}
