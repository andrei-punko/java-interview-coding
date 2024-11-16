package by.andd3dfx.numeric;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SquareRootBabylonTest {

    @Test
    public void mySqrt() {
        assertThat(SquareRootBabylon.mySqrt(1)).isEqualTo(1);
        assertThat(SquareRootBabylon.mySqrt(2)).isEqualTo(1);
        assertThat(SquareRootBabylon.mySqrt(3)).isEqualTo(1);
        assertThat(SquareRootBabylon.mySqrt(4)).isEqualTo(2);
        assertThat(SquareRootBabylon.mySqrt(5)).isEqualTo(2);
        assertThat(SquareRootBabylon.mySqrt(8)).isEqualTo(2);
        assertThat(SquareRootBabylon.mySqrt(9)).isEqualTo(3);
        assertThat(SquareRootBabylon.mySqrt(624)).isEqualTo(24);
        assertThat(SquareRootBabylon.mySqrt(625)).isEqualTo(25);
        assertThat(SquareRootBabylon.mySqrt(789)).isEqualTo(28);
    }
}
