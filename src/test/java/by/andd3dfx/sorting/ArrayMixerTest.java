package by.andd3dfx.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayMixerTest {

    private final Integer[] INTEGERS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final String[] STRINGS = {"Andrei", "Nina", "Uladzimir", "Olga", "Yulia"};

    @Test
    public void applyForInteger() {
        shuffleAndCheckResult(INTEGERS);
    }

    @Test
    public void applyForString() {
        shuffleAndCheckResult(STRINGS);
    }

    private <T> void shuffleAndCheckResult(T[] arrayToShuffle) {
        var array = arrayToShuffle.clone();
        assertThat(array).isEqualTo(arrayToShuffle);
        System.out.println("Initial array: " + Arrays.toString(arrayToShuffle));

        ArrayMixer.apply(array);

        assertThat(array).isNotEqualTo(arrayToShuffle);
        System.out.println("Shuffled array: " + Arrays.toString(array));
    }
}
