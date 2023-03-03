package by.andd3dfx.numeric;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RaiseToPowerTest {

    @Test
    public void applyForZero() {
        assertThat("3^0 = 1", RaiseToPower.apply(3f, 0), is(1f));
    }

    @Test
    public void applyForPositive() {
        assertThat("3^3 = 9", RaiseToPower.apply(3f, 3), is(27f));
        assertThat("3^5 = 243", RaiseToPower.apply(3f, 5), is(243f));
        assertThat("2^13 = 8192", RaiseToPower.apply(2f, 13), is(8192f));
    }

    @Test
    public void applyForNegative() {
        assertThat("2^-2 = 0.25", RaiseToPower.apply(2f, -2), is(0.25f));
        assertThat("3^-3 = 0.037037037", RaiseToPower.apply(3f, -3), is(0.037037037f));
    }

    @Test
    public void applyEnhancedForZero() {
        assertThat("3^0 = 1", RaiseToPower.applyEnhanced(3f, 0), is(1f));
    }

    @Test
    public void applyEnhancedForPositive() {
        assertThat("3^3 = 9", RaiseToPower.applyEnhanced(3f, 3), is(27f));
        assertThat("3^5 = 243", RaiseToPower.applyEnhanced(3f, 5), is(243f));
        assertThat("2^13 = 8192", RaiseToPower.applyEnhanced(2f, 13), is(8192f));
    }

    @Test
    public void applyEnhancedForNegative() {
        assertThat("2^-2 = 0.25", RaiseToPower.applyEnhanced(2f, -2), is(0.25f));
        assertThat("3^-3 = 0.037037037", RaiseToPower.applyEnhanced(3f, -3), is(0.037037037f));
    }
}
