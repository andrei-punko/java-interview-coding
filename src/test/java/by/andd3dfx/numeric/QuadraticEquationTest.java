package by.andd3dfx.numeric;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuadraticEquationTest {

    @Test
    public void solve() {
        assertThat(QuadraticEquation.solve(1, -2, 1)).isEqualTo(new double[]{1.0, 1.0});
        assertThat(QuadraticEquation.solve(1, -5, 6)).isEqualTo(new double[]{2.0, 3.0});
        assertThat(QuadraticEquation.solve(1, -2, 5)).isEqualTo(null);
    }
}