package by.andd3dfx.recursion;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class BrickPyramidTest {

    @Test
    public void w() {
        assertThat(BrickPyramid.w(0, 0), is(0.0));
        assertThat(BrickPyramid.w(1, 0), is(0.5));
        assertThat(BrickPyramid.w(1, 1), is(0.5));

        assertThat(BrickPyramid.w(2, 0), is(0.75));
        assertThat(BrickPyramid.w(2, 1), is(1.5));
        assertThat(BrickPyramid.w(2, 2), is(0.75));

        assertThat(BrickPyramid.w(3, 0), is(0.875));
        assertThat(BrickPyramid.w(3, 1), is(2.125));
        assertThat(BrickPyramid.w(3, 2), is(2.125));
        assertThat(BrickPyramid.w(3, 3), is(0.875));

        assertThat(BrickPyramid.w(322, 156), is(306.48749781747574));
    }

    @Test
    public void wWithWrongParams() {
        checkWExceptionPresenceWithWrongParams(-1, 1);
        checkWExceptionPresenceWithWrongParams(1, -1);
        checkWExceptionPresenceWithWrongParams(-1, -1);
        checkWExceptionPresenceWithWrongParams(2, 3);
    }

    private static void checkWExceptionPresenceWithWrongParams(int row, int pos) {
        try {
            BrickPyramid.w(row, pos);
            fail("Exception should be thrown!");
        } catch (IllegalArgumentException iae) {
            assertThat(iae.getMessage(), is("row and pos should satisfy conditions: row>=0, pos>=0, row>=pos"));
        }
    }
}