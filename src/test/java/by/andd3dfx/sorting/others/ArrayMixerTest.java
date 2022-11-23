package by.andd3dfx.sorting.others;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayMixerTest {

    private final Integer[] INTEGERS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final String[] STRINGS = {"Aasd", "asda", "rteg", "f", "677g"};

    @Test
    public void applyForInteger() {
        var array = INTEGERS.clone();
        assertThat(array).isEqualTo(INTEGERS);
        System.out.println(Arrays.toString(array));

        ArrayMixer.apply(array);

        assertThat(array).isNotEqualTo(INTEGERS);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void applyForString() {
        var array = STRINGS.clone();
        assertThat(array).isEqualTo(STRINGS);
        System.out.println(Arrays.toString(array));

        ArrayMixer.apply(array);

        assertThat(array).isNotEqualTo(STRINGS);
        System.out.println(Arrays.toString(array));
    }
}
