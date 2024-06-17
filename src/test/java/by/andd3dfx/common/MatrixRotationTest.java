package by.andd3dfx.common;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixRotationTest {

    private final List<List<Integer>> EXPECTED_MATRIX = List.of(
            List.of(3, 4, 5, 6),
            List.of(2, 3, 4, 7),
            List.of(1, 2, 1, 8),
            List.of(12, 11, 10, 9)
    );

    @Test
    public void rotate() {
        var matrix = buildMatrix();

        MatrixRotation.rotate(matrix, 2);

        assertThat(matrix).isEqualTo(EXPECTED_MATRIX);
    }

    @Test
    public void rotateForBigR() {
        var matrix = buildMatrix();

        MatrixRotation.rotate(matrix, 14);

        assertThat(matrix).isEqualTo(EXPECTED_MATRIX);
    }

    @Test
    public void rotateWhenNoRotation() {
        var matrix = buildMatrix();

        MatrixRotation.rotate(matrix, 0);

        assertThat(matrix).isEqualTo(buildMatrix());
    }

    @Test
    public void rotateWhenNoRotation2() {
        var matrix = buildMatrix();

        MatrixRotation.rotate(matrix, 12);

        assertThat(matrix).isEqualTo(buildMatrix());
    }

    @Test
    public void rotateForNegativeR() {
        var matrix = buildMatrix();

        MatrixRotation.rotate(matrix, -10);

        assertThat(matrix).isEqualTo(EXPECTED_MATRIX);
    }

    private static List<List<Integer>> buildMatrix() {
        return List.of(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(12, 1, 2, 5),
                Arrays.asList(11, 4, 3, 6),
                Arrays.asList(10, 9, 8, 7)
        );
    }
}
