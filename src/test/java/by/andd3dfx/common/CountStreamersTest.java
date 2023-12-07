package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.CountStreamers.count;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CountStreamersTest {

    @Test
    public void countWithoutOverlapping() {
        int[][] times = {
                {10, 30},
                {40, 50}
        };

        assertThat(count(times), is(1));
    }

    @Test
    public void countWithOverlapping() {
        int[][] times = {
                {10, 30},
                {20, 50}
        };

        assertThat(count(times), is(2));
    }

    @Test
    public void countComplexCase() {
        int[][] times = {
                {10, 30},
                {20, 40},
                {39, 50},
                {60, 110},
                {80, 90},
                {30, 70},
                {10, 120}
        };

        assertThat(count(times), is(4));
    }
}
