package by.andd3dfx.common;

import static by.andd3dfx.common.TrappingRainWater.trap;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TrappingRainWaterTest {

    @Test
    public void testTrap() {
        assertThat(trap(new int[]{1, 0, 1})).isEqualTo(1);
        assertThat(trap(new int[]{1, 0, 2})).isEqualTo(1);
        assertThat(trap(new int[]{3, 0, 2})).isEqualTo(2);
        assertThat(trap(new int[]{1, 3, 1, 2, 0, 1})).isEqualTo(2);

        assertThat(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})).isEqualTo(6);
        assertThat(trap(new int[]{4, 2, 0, 3, 2, 5})).isEqualTo(9);
    }
}
