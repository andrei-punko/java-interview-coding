package by.andd3dfx.search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static by.andd3dfx.search.CountNegativesInSortedMatrix.count_MN;
import static by.andd3dfx.search.CountNegativesInSortedMatrix.count_NPlusM;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @see <a href="https://youtu.be/QIwQCzDU3XM">Video solution</a>
 */
public class CountNegativesInSortedMatrixTest {

    private record Grid(int[][] value) {
        @Override
        public String toString() {
            return Arrays.deepToString(value);
        }
    }

    static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new Grid(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}), 8),
            Arguments.of(new Grid(new int[][]{{3, 2}, {1, 0}}), 0),
            Arguments.of(new Grid(new int[][]{}), 0)
        );
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("data")
    public void testCount_MN(Grid grid, int expectedResult) {
        assertThat(count_MN(grid.value())).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("data")
    public void testCount_NPlusM(Grid grid, int expectedResult) {
        assertThat(count_NPlusM(grid.value())).isEqualTo(expectedResult);
    }
}
