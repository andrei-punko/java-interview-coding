package by.andd3dfx.search;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InterpolationSearchTest {

    @Test
    public void perform() {
        assertThat(InterpolationSearch.perform(new int[]{1, 2, 3, 4, 5}, 4))
            .isEqualTo(3);
        assertThat(InterpolationSearch.perform(new int[]{1, 2, 2, 3, 4, 8}, 2))
            .isEqualTo(1);
        assertThat(InterpolationSearch.perform(new int[]{-2, -1, 1, 2, 5, 8, 9, 12, 15}, 12))
            .isEqualTo(7);
    }

    @Test
    public void performWhenNothingFound() {
        assertThat(InterpolationSearch.perform(new int[]{1, 2, 3, 4, 5}, 41))
            .isEqualTo(-1);
    }

    @Test
    public void determineMid() {
        assertThat(InterpolationSearch.determineMid(new int[]{0, 1, 2, 3, 4, 5}, 3, 0, 5))
            .isEqualTo(3);
        assertThat(InterpolationSearch.determineMid(new int[]{0, 1, 2, 3, 4, 25}, 3, 0, 5))
            .isEqualTo(0);
    }
}
