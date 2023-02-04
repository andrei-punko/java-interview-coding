package by.andd3dfx.sorting.others;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class InsertionSortTest {

    @Test
    public void applyForEmpty() {
        Integer[] array = {};

        InsertionSort.apply(array);

        assertThat(array).isEqualTo(new Integer[]{});
    }

    @Test
    public void apply() {
        Integer[] array = {1, 4, 8, 6, 9, -2, 5};

        InsertionSort.apply(array);

        assertThat(array).isEqualTo(new Integer[]{-2, 1, 4, 5, 6, 8, 9});
    }
}