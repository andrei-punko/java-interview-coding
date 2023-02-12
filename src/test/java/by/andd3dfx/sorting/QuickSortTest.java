package by.andd3dfx.sorting;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest {

    @Test
    public void applyForEmpty() {
        Integer[] array = {};

        QuickSort.apply(array);

        assertThat(array).isEqualTo(new Integer[]{});
    }

    @Test
    public void applyForInt() {
        Integer[] array = {4, 1, 6, 9, -2, 8, 5};

        QuickSort.apply(array);

        assertThat(array).isEqualTo(new Integer[]{-2, 1, 4, 5, 6, 8, 9});
    }

    @Test
    public void applyForString() {
        String[] array = {"Юлия", "Андрей", "Елена", "Павел", "Тихон"};

        QuickSort.apply(array);

        assertThat(array).isEqualTo(new String[]{"Андрей", "Елена", "Павел", "Тихон", "Юлия"});
    }
}
