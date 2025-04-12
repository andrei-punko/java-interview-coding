package by.andd3dfx.numeric;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntDividerTest {

    @Test
    public void divide() {
        assertThat(IntDivider.divide(5, 2)).isEqualTo(2);
        assertThat(IntDivider.divide(36, 4)).isEqualTo(9);
        assertThat(IntDivider.divide(45, 7)).isEqualTo(6);
        assertThat(IntDivider.divide(500, 2)).isEqualTo(250);
        assertThat(IntDivider.divide(100, 1)).isEqualTo(100);
        assertThat(IntDivider.divide(3, 5)).isEqualTo(0);
    }

    @Test
    public void divideOptimized() {
        assertThat(IntDivider.divideOptimized(5, 2)).isEqualTo(2);
        assertThat(IntDivider.divideOptimized(36, 4)).isEqualTo(9);
        assertThat(IntDivider.divideOptimized(45, 7)).isEqualTo(6);
        assertThat(IntDivider.divideOptimized(500, 2)).isEqualTo(250);
        assertThat(IntDivider.divideOptimized(100, 1)).isEqualTo(100);
        assertThat(IntDivider.divideOptimized(3, 5)).isEqualTo(0);
    }
}
