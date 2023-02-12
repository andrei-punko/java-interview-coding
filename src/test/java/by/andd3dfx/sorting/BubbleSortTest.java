package by.andd3dfx.sorting;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BubbleSortTest {

    @Test
    public void applyForEmpty() {
        Integer[] array = {};

        BubbleSort.apply(array);

        assertThat(array).isEqualTo(new Integer[]{});
    }

    @Test
    public void apply() {
        Integer[] array = {1, 4, 6, 8, 9, -2, 5};

        BubbleSort.apply(array);

        assertThat(array).isEqualTo(new Integer[]{-2, 1, 4, 5, 6, 8, 9});
    }

    @Test
    public void apply2ForEmpty() {
        Integer[] array = {};

        BubbleSort.apply2(array);

        assertThat(array).isEqualTo(new Integer[]{});
    }

    @Test
    public void apply2() {
        Integer[] array = {1, 4, 6, 8, 9, -2, 5};

        BubbleSort.apply2(array);

        assertThat(array).isEqualTo(new Integer[]{-2, 1, 4, 5, 6, 8, 9});
    }
}