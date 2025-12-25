package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixRotationTest {

    private final int[][] EXPECTED_MATRIX = new int[][]{
        {3, 4, 5, 6},
        {2, 3, 4, 7},
        {1, 2, 1, 8},
        {12, 11, 10, 9}
    };

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

    private static int[][] buildMatrix() {
        return new int[][]{
            {1, 2, 3, 4},
            {12, 1, 2, 5},
            {11, 4, 3, 6},
            {10, 9, 8, 7}

        };
    }
}
