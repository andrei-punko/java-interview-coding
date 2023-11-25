package by.andd3dfx.numeric;

import org.junit.Test;

import java.util.List;

import static by.andd3dfx.numeric.MaxSum.findMaxSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class MaxSumTest {

    @Test
    public void testFindMaxSum() {
        assertThat(findMaxSum(List.of(3, 2))).isEqualTo(5);
        assertThat(findMaxSum(List.of(5, 9, 7, 11))).isEqualTo(20);
        assertThat(findMaxSum(List.of(5, 9, 1, 9))).isEqualTo(18);
    }

    @Test
    public void testFindMaxSumWhenWrongInput() {
        makeCallAndCheckExceptionThrow(null);
        makeCallAndCheckExceptionThrow(List.of());
        makeCallAndCheckExceptionThrow(List.of(4));
    }

    private static void makeCallAndCheckExceptionThrow(List<Integer> list) {
        var ex = assertThrows(IllegalArgumentException.class, () -> findMaxSum(list));
        assertThat(ex.getMessage()).isEqualTo("List size should be at least 2!");
    }
}
