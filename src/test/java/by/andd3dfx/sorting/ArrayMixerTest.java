package by.andd3dfx.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayMixerTest {

    private final Integer[] INTEGERS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final String[] STRINGS = {"Andrei", "Nina", "Vladimir", "Olga", "Tikhon", "Dmitry"};

    @Test
    public void shuffleForIntegers() {
        shuffleAndCheckResult(INTEGERS);
    }

    @Test
    public void shuffleForStrings() {
        shuffleAndCheckResult(STRINGS);
    }

    private <T> void shuffleAndCheckResult(T[] items) {
        var initial = items.clone();

        ArrayMixer.shuffle(items);

        assertThat(items.length).isEqualTo(initial.length);
        assertThat(items).isNotEqualTo(initial);

        System.out.println("Initial array: " + Arrays.toString(initial));
        System.out.println("Shuffled array: " + Arrays.toString(items));
    }
}
