package by.andd3dfx.numeric;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class MaxMultiplicationTest {

    @Test
    public void maxMultiplication() {
        assertThat("Wrong result for all positive values",
            MaxMultiplication.maxMultiplication(new int[]{1, 4, 3, 8, 1}), is(96L));
        assertThat("Wrong result for one negative value",
            MaxMultiplication.maxMultiplication(new int[]{1, -3, 4, 8, 2}), is(64L));
        assertThat("Wrong result for two negative values",
            MaxMultiplication.maxMultiplication(new int[]{-1, 3, 4, -2, 1}), is(12L));
        assertThat("Wrong result for all negative values",
            MaxMultiplication.maxMultiplication(new int[]{-1, -3, -4, -2, -1}), is(-2L));
    }
}
