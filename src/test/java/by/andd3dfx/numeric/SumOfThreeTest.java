package by.andd3dfx.numeric;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SumOfThreeTest {

    @Test
    public void find_N3() {
        int[] a = {1, 2, 3};
        int[] b = {10, 20, 30};
        int[] c = {-1, 0, 1};

        var result = SumOfThree.find_N3(a, b, c, 22);

        assertTrue(result.isExists());
        assertThat(result.getIndexes().length).isEqualTo(3);
        assertThat(result.getIndexes()[0]).isEqualTo(0);
        assertThat(result.getIndexes()[1]).isEqualTo(1);
        assertThat(result.getIndexes()[2]).isEqualTo(2);
    }

    @Test
    public void find_N2logN() {
        int[] a = {1, 2, 3};
        int[] b = {10, 20, 30};
        int[] c = {-1, 0, 1};

        var result = SumOfThree.find_N2logN(a, b, c, 22);

        assertTrue(result.isExists());
        assertThat(result.getIndexes().length).isEqualTo(3);
        assertThat(result.getIndexes()[0]).isEqualTo(0);
        assertThat(result.getIndexes()[1]).isEqualTo(1);
        assertThat(result.getIndexes()[2]).isEqualTo(2);
    }

    @Test
    public void find_N3WhenNoSolution() {
        int[] a = {1, 2, 3};
        int[] b = {10, 20, 30};
        int[] c = {-1, 0, 1};

        var result = SumOfThree.find_N3(a, b, c, 45);

        assertFalse(result.isExists());
        assertThat(result.getIndexes()).isNull();
    }

    @Test
    public void find_N2logNWhenNoSolution() {
        int[] a = {1, 2, 3};
        int[] b = {10, 20, 30};
        int[] c = {-1, 0, 1};

        var result = SumOfThree.find_N2logN(a, b, c, 45);

        assertFalse(result.isExists());
        assertThat(result.getIndexes()).isNull();
    }
}