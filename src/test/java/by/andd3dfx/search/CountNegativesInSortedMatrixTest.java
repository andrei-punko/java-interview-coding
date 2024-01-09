package by.andd3dfx.search;

import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static by.andd3dfx.search.CountNegativesInSortedMatrix.count_MN;
import static by.andd3dfx.search.CountNegativesInSortedMatrix.count_MNOptimized;
import static by.andd3dfx.search.CountNegativesInSortedMatrix.count_NPlusM;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
@RunWith(Parameterized.class)
public class CountNegativesInSortedMatrixTest {

    private final Grid grid;
    private final int expectedResult;

    private record Grid(int[][] value) {
        @Override
        public String toString() {
            return Arrays.deepToString(value);
        }
    }

    @Parameters(name = "{0} -> {1}")
    public static Collection<Object[]> data() {
        return asList(
                new Object[]{new Grid(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}), 8},
                new Object[]{new Grid(new int[][]{{3, 2}, {1, 0}}), 0},
                new Object[]{new Grid(new int[][]{}), 0}
        );
    }

    @Test
    public void testCount_NM() {
        assertThat(count_MN(grid.value)).isEqualTo(expectedResult);
    }

    @Test
    public void testCount_NMOptimized() {
        assertThat(count_MNOptimized(grid.value)).isEqualTo(expectedResult);
    }

    @Test
    public void testCount_NPlusM() {
        assertThat(count_NPlusM(grid.value)).isEqualTo(expectedResult);
    }
}
