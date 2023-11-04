package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.MeanMedianMode.mean;
import static by.andd3dfx.numeric.MeanMedianMode.median;
import static by.andd3dfx.numeric.MeanMedianMode.mode;
import static by.andd3dfx.numeric.MeanMedianMode.quartile1;
import static by.andd3dfx.numeric.MeanMedianMode.quartile2;
import static by.andd3dfx.numeric.MeanMedianMode.quartile3;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MeanMedianModeTest {

    @Test
    public void testMean() {
        assertThat(mean(new int[]{1, 6, 3, 4, 5, 2, 7}), is(4.0));
    }

    @Test
    public void testMeanForListOfSameNumbers() {
        assertThat(mean(new int[]{2, 2, 2, 2, 2, 2, 2}), is(2.0));
    }

    @Test
    public void testMedianForOddAmountOfNumbers() {
        assertThat(median(new int[]{1, 6, 3, 4, 5, 2, 7}), is(4.0));
    }

    @Test
    public void testMedianForEvenAmountOfNumbers() {
        assertThat(median(new int[]{1, 2, 3, 4}), is(2.5));
    }

    @Test
    public void testMode() {
        assertThat("Wrong value for 1,2,3,4", mode(new int[]{1, 2, 3, 4}), is(1.0));
        assertThat("Wrong value for 2,2,5,5", mode(new int[]{2, 2, 5, 5}), is(2.0));
        assertThat("Wrong value for 5,5,2,2", mode(new int[]{5, 5, 2, 2}), is(2.0));
    }

    @Test
    public void testQuartile1() {
        assertThat(quartile1(new int[]{3, 7, 8, 5, 12, 14, 21, 13, 18}), is(6.0));
        assertThat(quartile1(new int[]{2, 2, 2, 2, 1, 1, 1, 1, 1}), is(1.0));
    }

    @Test
    public void testQuartile2() {
        assertThat(quartile2(new int[]{1, 6, 3, 4, 5, 2, 7}), is(4.0));
    }

    @Test
    public void testQuartile3() {
        assertThat(quartile3(new int[]{3, 7, 8, 5, 12, 14, 21, 13, 18}), is(16.0));
        assertThat(quartile3(new int[]{2, 2, 2, 2, 1, 1, 1, 1, 1}), is(2.0));
    }
}
