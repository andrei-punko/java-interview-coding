package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.MeanMedianMode.mean;
import static by.andd3dfx.numeric.MeanMedianMode.median;
import static by.andd3dfx.numeric.MeanMedianMode.mode;
import static by.andd3dfx.numeric.MeanMedianMode.quartile1;
import static by.andd3dfx.numeric.MeanMedianMode.quartile2;
import static by.andd3dfx.numeric.MeanMedianMode.quartile3;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MeanMedianModeTest {

    @Test
    public void testMean() {
        assertThat(mean(new int[]{2, 2, 2, 2, 2}), is(2.0));
        assertThat(mean(new int[]{1, 2, 3, 4}), is(2.5));
        assertThat(mean(new int[]{1, 2, 3, 8}), is(3.5));
    }

    @Test
    public void testMedian() {
        assertThat(median(new int[]{2, 2, 2, 2, 2}), is(2.0));
        assertThat(median(new int[]{1, 2, 3, 4}), is(2.5));
        assertThat(median(new int[]{1, 2, 3, 8}), is(2.5));
    }

    @Test
    public void testMode() {
        assertThat(mode(new int[]{1, 1, 1, 1}), is(1.0));
        assertThat(mode(new int[]{1, 2, 3, 4}), is(1.0));
        assertThat(mode(new int[]{1, 3, 3, 2, 5, 9}), is(3.0));
        assertThat(mode(new int[]{1, 3, 3, 2, 5, 2, 9}), is(2.0));
    }

    @Test
    public void testQuartile1() {
        assertThat(quartile1(new int[]{1, 1, 1, 1}), is(1.0));
        assertThat(quartile1(new int[]{5, 6, 7, 8, 1, 2, 3, 4}), is(2.5));
    }

    @Test
    public void testQuartile2() {
        assertThat(quartile2(new int[]{1, 1, 1, 1}), is(1.0));
        assertThat(quartile2(new int[]{5, 6, 7, 8, 1, 2, 3, 4}), is(4.5));
    }

    @Test
    public void testQuartile3() {
        assertThat(quartile3(new int[]{1, 1, 1, 1}), is(1.0));
        assertThat(quartile3(new int[]{5, 6, 7, 8, 1, 2, 3, 4}), is(6.5));
    }
}
