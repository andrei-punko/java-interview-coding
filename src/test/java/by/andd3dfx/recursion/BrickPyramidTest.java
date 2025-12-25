package by.andd3dfx.recursion;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class BrickPyramidTest {

    @Test
    public void w() {
        assertThat(BrickPyramid.w(0, 0)).isEqualTo(0.0);
        assertThat(BrickPyramid.w(1, 0)).isEqualTo(0.5);
        assertThat(BrickPyramid.w(1, 1)).isEqualTo(0.5);

        assertThat(BrickPyramid.w(2, 0)).isEqualTo(0.75);
        assertThat(BrickPyramid.w(2, 1)).isEqualTo(1.5);
        assertThat(BrickPyramid.w(2, 2)).isEqualTo(0.75);

        assertThat(BrickPyramid.w(3, 0)).isEqualTo(0.875);
        assertThat(BrickPyramid.w(3, 1)).isEqualTo(2.125);
        assertThat(BrickPyramid.w(3, 2)).isEqualTo(2.125);
        assertThat(BrickPyramid.w(3, 3)).isEqualTo(0.875);

        assertThat(BrickPyramid.w(322, 156)).isEqualTo(306.48749781747574);
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
            assertThat(iae.getMessage())
                .isEqualTo("row and pos should satisfy conditions: row>=0, pos>=0, row>=pos");
        }
    }
}
