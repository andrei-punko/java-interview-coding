package by.andd3dfx.dynamic;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoldDiggerTest {

    private GoldDigger goldDigger;

    @Before
    public void setUp() throws Exception {
        goldDigger = new GoldDigger();
    }

    @Test
    public void solveSimple() {
        var goldMatrix = new int[][]{
            {0},
            {5, 8},
            {9, 8, 2},
        };
        assertThat(goldDigger.solve(goldMatrix)).isEqualTo(16);
    }

    @Test
    public void solve() {
        var goldMatrix = new int[][]{
            {0},
            {5, 8},
            {9, 8, 2},
            {1, 3, 5, 6},
            {6, 2, 4, 4, 5},
            {9, 5, 3, 5, 5, 7},
            {7, 4, 6, 4, 7, 6, 8}
        };
        assertThat(goldDigger.solve(goldMatrix)).isEqualTo(37);
    }
}
