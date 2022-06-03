package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeArraysTest {

    @Test
    public void merge() {
        assertThat(MergeArrays.merge(new int[][]{
                {1, 2, 3}, {4, 6, 7}, {2, 5, 9}
        })).isEqualTo(new int[]{1, 2, 2, 3, 4, 5, 6, 7, 9});

        assertThat(MergeArrays.merge(new int[][]{
                {3, 6, 8}, {1, 4, 9}, {1, 2, 8}
        })).isEqualTo(new int[]{1, 1, 2, 3, 4, 6, 8, 8, 9});
    }

    @Test
    public void mergeForEmpty() {
        assertThat(MergeArrays.merge(new int[][]{}))
                .isEqualTo(new int[]{});

        assertThat(MergeArrays.merge(new int[][]{
                {}, {}, {}
        })).isEqualTo(new int[]{});
    }
}
