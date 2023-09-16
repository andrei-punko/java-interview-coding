package by.andd3dfx.common;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixRotationTest {

    private final List<List<Integer>> MATRIX = List.of(
            Arrays.asList(1, 2, 3, 4),
            Arrays.asList(12, 1, 2, 5),
            Arrays.asList(11, 4, 3, 6),
            Arrays.asList(10, 9, 8, 7)
    );
    private final List<List<Integer>> EXPECTED_RESULT = List.of(
            Arrays.asList(3, 4, 5, 6),
            Arrays.asList(2, 3, 4, 7),
            Arrays.asList(1, 2, 1, 8),
            Arrays.asList(12, 11, 10, 9)
    );

    @Test
    public void matrixRotation() {
        MatrixRotation.matrixRotation(MATRIX, 2);

        assertThat(MATRIX).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    public void matrixRotationForBigR() {
        MatrixRotation.matrixRotation(MATRIX, 14);

        assertThat(MATRIX).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    public void matrixRotationWhenNoRotation() {
        MatrixRotation.matrixRotation(MATRIX, 0);

        assertThat(MATRIX).isEqualTo(MATRIX);
    }

    @Test
    public void matrixRotationAfterTwoConsequentRotations() {
        MatrixRotation.matrixRotation(MATRIX, 1);
        MatrixRotation.matrixRotation(MATRIX, 1);

        assertThat(MATRIX).isEqualTo(EXPECTED_RESULT);
    }
}
