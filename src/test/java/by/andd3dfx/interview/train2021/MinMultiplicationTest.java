package by.andd3dfx.interview.train2021;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MinMultiplicationTest {

    private MinMultiplication multiplication;

    @Before
    public void setUp() throws Exception {
        multiplication = new MinMultiplication();
    }

    @Test
    public void minMultiplicationWhenAllPositive() {
        int result = multiplication.minMultiplication(new int[]{1, 4, 3, 2});

        assertThat(result, is(2));
    }

    @Test
    public void minMultiplicationWhenAllNegative() {
        int result = multiplication.minMultiplication(new int[]{-1, -2, -4, -3});

        assertThat(result, is(2));
    }

    @Test
    public void minMultiplicationWhenBothNegativeNPositive() {
        int result = multiplication.minMultiplication(new int[]{1, 2, -3, 4, -2});

        assertThat(result, is(-12));
    }
}