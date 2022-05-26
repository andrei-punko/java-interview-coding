package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArraysUnionTest {

    @Test
    public void uniteViaStreams() {
        // Overlapping arrays case
        assertThat(ArraysUnion.unite(new int[]{1, 2, 3, 7}, new int[]{2, 3, 4, 6}))
                .isEqualTo(new Integer[]{1, 2, 3, 4, 6, 7});
        assertThat(ArraysUnion.unite(new int[]{2, 3, 4, 6}, new int[]{1, 2, 3, 7}))
                .isEqualTo(new Integer[]{1, 2, 3, 4, 6, 7});

        // Non-overlapping arrays case
        assertThat(ArraysUnion.unite(new int[]{1, 2, 3}, new int[]{10, 11, 12}))
                .isEqualTo(new Integer[]{1, 2, 3, 10, 11, 12});
        assertThat(ArraysUnion.unite(new int[]{10, 11, 12}, new int[]{1, 2, 3}))
                .isEqualTo(new Integer[]{1, 2, 3, 10, 11, 12});
    }

    @Test
    public void uniteViaManualIteration() {
        // Overlapping arrays case
        assertThat(ArraysUnion.unite2(new int[]{1, 2, 3, 7}, new int[]{2, 3, 4, 6}))
                .isEqualTo(new Integer[]{1, 2, 3, 4, 6, 7});
        assertThat(ArraysUnion.unite2(new int[]{2, 3, 4, 6}, new int[]{1, 2, 3, 7}))
                .isEqualTo(new Integer[]{1, 2, 3, 4, 6, 7});

        // Non-overlapping arrays case
        assertThat(ArraysUnion.unite2(new int[]{1, 2, 3}, new int[]{10, 11, 12}))
                .isEqualTo(new Integer[]{1, 2, 3, 10, 11, 12});
        assertThat(ArraysUnion.unite2(new int[]{10, 11, 12}, new int[]{1, 2, 3}))
                .isEqualTo(new Integer[]{1, 2, 3, 10, 11, 12});
    }
}
