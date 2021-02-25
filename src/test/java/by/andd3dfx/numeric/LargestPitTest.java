package by.andd3dfx.numeric;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class LargestPitTest {

    @Test
    public void find() {
        assertThat(LargestPit.find(new int[]{}), is(0));
        assertThat(LargestPit.find(new int[]{1}), is(0));
        assertThat(LargestPit.find(new int[]{1, 2}), is(0));
        assertThat(LargestPit.find(new int[]{4, 4, 3, 2, 1, 0}), is(-1));
        assertThat(LargestPit.find(new int[]{0, 0, 1, 2, 3, 4}), is(-1));
        assertThat(LargestPit.find(new int[]{2, 1, 2, -1, 3}), is(3));
        assertThat(LargestPit.find(new int[]{1, 0, 1, -2, 0}), is(2));
        assertThat(LargestPit.find(new int[]{0, -1, 1, -2, 0, -3, 1, -4, 0, -5}), is(4));
    }
}
