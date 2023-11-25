package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArraysUnionTest {

    @Test
    public void uniteUsingStreams() {
        // Overlapping arrays case
        assertThat(ArraysUnion.uniteUsingStreams(new int[]{1, 2, 3, 7}, new int[]{2, 3, 4, 6}))
                .isEqualTo(new Integer[]{1, 2, 3, 4, 6, 7});
        assertThat(ArraysUnion.uniteUsingStreams(new int[]{2, 3, 4, 6}, new int[]{1, 2, 3, 7}))
                .isEqualTo(new Integer[]{1, 2, 3, 4, 6, 7});

        // Non-overlapping arrays case
        assertThat(ArraysUnion.uniteUsingStreams(new int[]{1, 2, 3}, new int[]{10, 11, 12}))
                .isEqualTo(new Integer[]{1, 2, 3, 10, 11, 12});
        assertThat(ArraysUnion.uniteUsingStreams(new int[]{10, 11, 12}, new int[]{1, 2, 3}))
                .isEqualTo(new Integer[]{1, 2, 3, 10, 11, 12});
    }

    @Test
    public void uniteUsingManualIteration() {
        // Overlapping arrays case
        assertThat(ArraysUnion.uniteUsingManualIteration(new int[]{1, 2, 3, 7}, new int[]{2, 3, 4, 6}))
                .isEqualTo(new Integer[]{1, 2, 3, 4, 6, 7});
        assertThat(ArraysUnion.uniteUsingManualIteration(new int[]{2, 3, 4, 6}, new int[]{1, 2, 3, 7}))
                .isEqualTo(new Integer[]{1, 2, 3, 4, 6, 7});

        // Non-overlapping arrays case
        assertThat(ArraysUnion.uniteUsingManualIteration(new int[]{1, 2, 3}, new int[]{10, 11, 12}))
                .isEqualTo(new Integer[]{1, 2, 3, 10, 11, 12});
        assertThat(ArraysUnion.uniteUsingManualIteration(new int[]{10, 11, 12}, new int[]{1, 2, 3}))
                .isEqualTo(new Integer[]{1, 2, 3, 10, 11, 12});
    }
}
