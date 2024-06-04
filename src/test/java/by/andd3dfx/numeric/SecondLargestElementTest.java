package by.andd3dfx.numeric;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SecondLargestElementTest {

    @Test
    public void find_NlogN() {
        int[] array = {3, 1, 2, 4};
        assertThat(SecondLargestElement.find_NlogN(array), is(3));

        int[] array2 = {3, 1, 2, 5, 8, 3, 7};
        assertThat(SecondLargestElement.find_NlogN(array2), is(7));
    }

    @Test
    public void find_N() {
        int[] array = {3, 1, 2, 4};
        assertThat(SecondLargestElement.find_N(array), is(3));

        int[] array2 = {3, 1, 2, 5, 8, 3, 7};
        assertThat(SecondLargestElement.find_N(array2), is(7));
    }
}