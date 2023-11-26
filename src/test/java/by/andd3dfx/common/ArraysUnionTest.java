package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.ArraysUnion.unite;
import static by.andd3dfx.common.ArraysUnion.uniteUsingSet;
import static org.assertj.core.api.Assertions.assertThat;

public class ArraysUnionTest {

    @Test
    public void unite_forOverlappingArrays() {
        assertThat(unite(new int[]{1, 2, 2, 5, 7, 9}, new int[]{2, 3, 4, 4, 6}))
                .isEqualTo(new int[]{1, 2, 3, 4, 5, 6, 7, 9});
    }

    @Test
    public void unite_forNonOverlappingArrays() {
        assertThat(unite(new int[]{1, 2, 3}, new int[]{10, 11, 12}))
                .isEqualTo(new int[]{1, 2, 3, 10, 11, 12});
        assertThat(unite(new int[]{10, 11, 12}, new int[]{1, 2, 3}))
                .isEqualTo(new int[]{1, 2, 3, 10, 11, 12});
    }

    @Test
    public void uniteUsingSet_forOverlappingArrays() {
        assertThat(uniteUsingSet(new int[]{1, 2, 2, 5, 7, 9}, new int[]{2, 3, 4, 4, 6}))
                .isEqualTo(new int[]{1, 2, 3, 4, 5, 6, 7, 9});
    }

    @Test
    public void uniteUsingSet_forNonOverlappingArrays() {
        assertThat(uniteUsingSet(new int[]{1, 2, 3}, new int[]{10, 11, 12}))
                .isEqualTo(new int[]{1, 2, 3, 10, 11, 12});
        assertThat(uniteUsingSet(new int[]{10, 11, 12}, new int[]{1, 2, 3}))
                .isEqualTo(new int[]{1, 2, 3, 10, 11, 12});
    }
}
