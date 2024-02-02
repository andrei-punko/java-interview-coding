package by.andd3dfx.sorting;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class HeapSortTest {

    @Test
    public void applyForEmpty() {
        Integer[] array = {};

        HeapSort.apply(array);

        assertThat(array).isEqualTo(new Integer[]{});
    }

    @Test
    public void apply() {
        Integer[] array = {1, 4, 8, 6, 9, -2, 5};

        HeapSort.apply(array);

        assertThat(array).isEqualTo(new Integer[]{-2, 1, 4, 5, 6, 8, 9});
    }

    @Test
    public void applyForString() {
        String[] array = {"Юлия", "Андрей", "Елена", "Павел", "Тихон"};

        HeapSort.apply(array);

        assertThat(array).isEqualTo(new String[]{"Андрей", "Елена", "Павел", "Тихон", "Юлия"});
    }
}
