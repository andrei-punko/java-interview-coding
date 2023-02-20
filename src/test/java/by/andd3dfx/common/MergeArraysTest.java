package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeArraysTest {

    @Test
    public void mergeForEmpty() {
        assertThat(MergeArrays.merge(new int[][]{
                {}
        })).isEqualTo(new int[]{});

        assertThat(MergeArrays.merge(new int[][]{
                {}, {}, {}
        })).isEqualTo(new int[]{});
    }

    @Test
    public void merge2() {
        assertThat(MergeArrays.merge(new int[][]{
                {3, 6, 8}, {1, 4, 9}
        })).isEqualTo(new int[]{1, 3, 4, 6, 8, 9});
    }

    @Test
    public void merge3() {
        assertThat(MergeArrays.merge(new int[][]{
                {3, 6, 8}, {1, 4, 9}, {1, 2, 8}
        })).isEqualTo(new int[]{1, 1, 2, 3, 4, 6, 8, 8, 9});
    }

    @Test
    public void merge4() {
        assertThat(MergeArrays.merge(new int[][]{
                {3, 6, 8}, {1, 4, 9}, {1, 2, 8}, {1, 2, 90}
        })).isEqualTo(new int[]{1, 1, 1, 2, 2, 3, 4, 6, 8, 8, 9, 90});
    }
}
