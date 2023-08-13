package by.andd3dfx.dynamic;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BestTimeToBuyNSellStockTest {

    private BestTimeToBuyNSellStock solver;

    @Before
    public void setUp() throws Exception {
        solver = new BestTimeToBuyNSellStock();
    }

    @Test
    public void maxProfit_ON2() {
        assertThat(solver.maxProfit_ON2(new int[]{1, 2})).isEqualTo(1);
        assertThat(solver.maxProfit_ON2(new int[]{2, 2})).isEqualTo(0);
        assertThat(solver.maxProfit_ON2(new int[]{2, 1, 2, 0, 1})).isEqualTo(1);
        assertThat(solver.maxProfit_ON2(new int[]{2, 1, 2, 0, 1, 2})).isEqualTo(2);
        assertThat(solver.maxProfit_ON2(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(5);
        assertThat(solver.maxProfit_ON2(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);
    }

    @Test
    public void maxProfit_ON() {
        assertThat(solver.maxProfit_ON(new int[]{1, 2})).isEqualTo(1);
        assertThat(solver.maxProfit_ON(new int[]{2, 2})).isEqualTo(0);
        assertThat(solver.maxProfit_ON(new int[]{2, 1, 2, 0, 1})).isEqualTo(1);
        assertThat(solver.maxProfit_ON(new int[]{2, 1, 2, 0, 1, 2})).isEqualTo(2);
        assertThat(solver.maxProfit_ON(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(5);
        assertThat(solver.maxProfit_ON(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);
    }
}