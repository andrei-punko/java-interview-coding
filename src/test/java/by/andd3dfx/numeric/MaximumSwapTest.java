package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.MaximumSwap.solve;
import static org.assertj.core.api.Assertions.assertThat;

public class MaximumSwapTest {

    @Test
    public void testSolve() {
        assertThat(solve(1)).isEqualTo(1);
        assertThat(solve(1234)).isEqualTo(4231);
        assertThat(solve(9973)).isEqualTo(9973);
        assertThat(solve(2576)).isEqualTo(7526);
        assertThat(solve(1993)).isEqualTo(9913);
        assertThat(solve(98368)).isEqualTo(98863);
    }
}
