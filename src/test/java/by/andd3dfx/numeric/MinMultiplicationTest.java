package by.andd3dfx.numeric;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MinMultiplicationTest {

    private MinMultiplication minMultiplication;

    @Before
    public void setUp() throws Exception {
        minMultiplication = new MinMultiplication();
    }

    @Test
    public void determineWhenAllPositive() {
        assertThat(minMultiplication.determine(new int[]{9, 4, 2, 5, 3}), is(6));
    }

    @Test
    public void determineWhenAllNegative() {
        assertThat(minMultiplication.determine(new int[]{-9, -4, -2, -5, -1, -3}), is(2));
    }

    @Test
    public void determineWhenBothPositiveAndNegative() {
        assertThat(minMultiplication.determine(new int[]{9, 4, -2, 5, -1, 3}), is(-18));
    }
}