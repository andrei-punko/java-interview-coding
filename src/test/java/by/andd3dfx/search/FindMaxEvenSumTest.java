package by.andd3dfx.search;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FindMaxEvenSumTest {

    @Test
    public void find() {
        assertThat(FindMaxEvenSum.find(new int[]{1, 3, 9, 2, 10})).isEqualTo(24);
    }

    @Test
    public void findForOddOnly() {
        assertThat(FindMaxEvenSum.find(new int[]{3, 5, 9})).isEqualTo(14);
    }

    @Test
    public void findForEvenOnly() {
        assertThat(FindMaxEvenSum.find(new int[]{10, 2, 4, 12, 20})).isEqualTo(48);
    }

    @Test
    public void findForEmpty() {
        assertThat(FindMaxEvenSum.find(new int[]{})).isEqualTo(0);
    }
}