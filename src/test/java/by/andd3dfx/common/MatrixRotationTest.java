package by.andd3dfx.common;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixRotationTest {

    private final List<List<Integer>> matrix = List.of(
            Arrays.asList(1, 2, 3, 4),
            Arrays.asList(12, 1, 2, 5),
            Arrays.asList(11, 4, 3, 6),
            Arrays.asList(10, 9, 8, 7)
    );
    private final List<List<Integer>> expectedResult = List.of(
            Arrays.asList(3, 4, 5, 6),
            Arrays.asList(2, 3, 4, 7),
            Arrays.asList(1, 2, 1, 8),
            Arrays.asList(12, 11, 10, 9)
    );

    @Test
    public void matrixRotation() {
        var result = MatrixRotation.matrixRotation(matrix, 2);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void matrixRotationWhenNoRotation() {
        var result = MatrixRotation.matrixRotation(matrix, 0);

        assertThat(result).isEqualTo(matrix);
    }

    @Test
    public void matrixRotationAfterTwoRotations() {
        var result = MatrixRotation.matrixRotation(
                MatrixRotation.matrixRotation(matrix, 1), 1
        );

        assertThat(result).isEqualTo(expectedResult);
    }
}
