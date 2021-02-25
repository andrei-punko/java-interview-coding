package by.andd3dfx.recursion;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class BrickPyramidTest {

    @Test
    public void weight() {
        assertThat("w(0,0) = 0.0", BrickPyramid.pressure(0, 0), is(0.0));

        assertThat("w(1,0) = 0.5", BrickPyramid.pressure(1, 0), is(0.5));
        assertThat("w(1,1) = 0.5", BrickPyramid.pressure(1, 1), is(0.5));

        assertThat("w(2,0) = 0.75", BrickPyramid.pressure(2, 0), is(0.75));
        assertThat("w(2,1) = 1.5", BrickPyramid.pressure(2, 1), is(1.5));
        assertThat("w(2,2) = 0.75", BrickPyramid.pressure(2, 2), is(0.75));

        assertThat("w(3,0) = 0.875", BrickPyramid.pressure(3, 0), is(0.875));
        assertThat("w(3,1) = 2.125", BrickPyramid.pressure(3, 1), is(2.125));
        assertThat("w(3,2) = 2.125", BrickPyramid.pressure(3, 2), is(2.125));
        assertThat("w(3,3) = 0.875", BrickPyramid.pressure(3, 3), is(0.875));

        assertThat("w(322,156) = 306.48749781747574", BrickPyramid.pressure(322, 156),
                is(306.48749781747574));
    }

    @Test
    public void weightWithWrongParams() {
        checkWeightWithWrongParams(-1, 1);
        checkWeightWithWrongParams(1, -1);
        checkWeightWithWrongParams(-1, -1);
        checkWeightWithWrongParams(2, 3);
    }

    private void checkWeightWithWrongParams(int row, int pos) {
        try {
            BrickPyramid.pressure(row, pos);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException iae) {
            assertThat("Wrong exception message", iae.getMessage(),
                    is("row and pos should satisfy conditions: row>=0, pos>=0, row>=pos"));
        }
    }
}
