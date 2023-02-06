package by.andd3dfx.numeric;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class IntDividerTest {

    @Test
    public void divide() {
        assertThat(IntDivider.divide(5, 2), is(2));
        assertThat(IntDivider.divide(36, 4), is(9));
        assertThat(IntDivider.divide(45, 7), is(6));
        assertThat(IntDivider.divide(500, 2), is(250));
        assertThat(IntDivider.divide(100, 1), is(100));
        assertThat(IntDivider.divide(3, 5), is(0));
    }

    @Test
    public void divideOptimized() {
        assertThat(IntDivider.divideOptimized(5, 2), is(2));
        assertThat(IntDivider.divideOptimized(36, 4), is(9));
        assertThat(IntDivider.divideOptimized(45, 7), is(6));
        assertThat(IntDivider.divideOptimized(500, 2), is(250));
        assertThat(IntDivider.divideOptimized(100, 1), is(100));
        assertThat(IntDivider.divideOptimized(3, 5), is(0));
    }
}
