package by.andd3dfx.sorting;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BucketSortTest {

    @Test
    public void applyForEmpty() {
        Integer[] array = {};

        BucketSort.apply(array);

        assertThat(array).isEqualTo(new Integer[]{});
    }

    @Test
    public void applyForInt() {
        Integer[] array = {4, 1, 6, 9, -2, 8, 5};

        BucketSort.apply(array);

        assertThat(array).isEqualTo(new Integer[]{-2, 1, 4, 5, 6, 8, 9});
    }

    @Test
    public void applyForDouble() {
        Double[] array = {21.3, 2.3, -3.4, 43.7, 4.5, -23.1, 5.2};

        BucketSort.apply(array);

        assertThat(array).isEqualTo(new Double[]{-23.1, -3.4, 2.3, 4.5, 5.2, 21.3, 43.7});
    }
}
