package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.ClimbingStairs.calc;
import static org.assertj.core.api.Assertions.assertThat;

public class ClimbingStairsTest {

    @Test
    public void testCalc() {
        assertThat(calc(0)).isEqualTo(1);   // []
        assertThat(calc(1)).isEqualTo(1);   // 1
        assertThat(calc(2)).isEqualTo(2);   // 1+1, 2
        assertThat(calc(3)).isEqualTo(3);   // 1+1+1, 1+2, 2+1
        assertThat(calc(4)).isEqualTo(5);   // 1+1+1+1, 2+2, 1+2+1, 2+1+1, 1+1+2
        assertThat(calc(5)).isEqualTo(8);   // 1+1+1+1+1, 1+2+2, 2+1+2, 2+2+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1
    }
}
