package by.andd3dfx.search;

import org.junit.Test;

import static by.andd3dfx.search.FirstNLastPosOfElementInSortedArray.searchRange;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstNLastPosOfElementInSortedArrayTest {

    @Test
    public void testSearchRange() {
        assertThat(searchRange(new int[]{1, 3}, 1))
                .isEqualTo(new int[]{0, 0});
        assertThat(searchRange(new int[]{1, 3}, 3))
                .isEqualTo(new int[]{1, 1});
        assertThat(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8))
                .isEqualTo(new int[]{3, 4});
        assertThat(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6))
                .isEqualTo(new int[]{-1, -1});
    }

    @Test
    public void testSearchRangeForEmptyArray() {
        assertThat(searchRange(new int[]{}, 0))
                .isEqualTo(new int[]{-1, -1});
    }
}
