package by.andd3dfx.numeric;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MeanMedianModeTest {

    @Test
    public void mean() {
        assertThat("Wrong value", MeanMedianMode.mean(new int[]{1, 6, 3, 4, 5, 2, 7}), is(4.0));
        assertThat("Wrong value for list of same numbers",
                MeanMedianMode.mean(new int[]{2, 2, 2, 2, 2, 2, 2}), is(2.0));
    }

    @Test
    public void median() {
        assertThat("Wrong value", MeanMedianMode.median(new int[]{1, 6, 3, 4, 5, 2, 7}), is(4.0));
        assertThat("Wrong value for even amount of numbers", MeanMedianMode.median(new int[]{1, 2, 3, 4}), is(2.5));
    }

    @Test
    public void mode() {
        assertThat("Wrong value for 1,2,3,4", MeanMedianMode.mode(new int[]{1, 2, 3, 4}), is(1.0));
        assertThat("Wrong value for 2,2,5,5", MeanMedianMode.mode(new int[]{2, 2, 5, 5}), is(2.0));
        assertThat("Wrong value for 5,5,2,2", MeanMedianMode.mode(new int[]{5, 5, 2, 2}), is(2.0));
    }

    @Test
    public void quartile1() {
        assertThat(MeanMedianMode.quartile1(new int[]{3, 7, 8, 5, 12, 14, 21, 13, 18}), is(6.0));
        assertThat(MeanMedianMode.quartile1(new int[]{2, 2, 2, 2, 1, 1, 1, 1, 1}), is(1.0));
    }

    @Test
    public void quartile2() {
        assertThat(MeanMedianMode.quartile2(new int[]{3, 7, 8, 5, 12, 14, 21, 13, 18}), is(12.0));
    }

    @Test
    public void quartile3() {
        assertThat(MeanMedianMode.quartile3(new int[]{3, 7, 8, 5, 12, 14, 21, 13, 18}), is(16.0));
        assertThat(MeanMedianMode.quartile3(new int[]{2, 2, 2, 2, 1, 1, 1, 1, 1}), is(2.0));
    }
}
