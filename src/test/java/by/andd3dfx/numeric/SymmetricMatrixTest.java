package by.andd3dfx.numeric;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SymmetricMatrixTest {

    @Test
    public void isSymmetric() {
        int[][] matrix = {
            {0, 1, 5},
            {1, 1, 3},
            {5, 3, 2},
        };
        assertTrue(SymmetricMatrix.isSymmetric(matrix));
    }

    @Test
    public void isSymmetricNegative() {
        int[][] matrix = {
            {0, 1, 5},
            {1, 1, 4},
            {5, 3, 2},
        };
        assertFalse(SymmetricMatrix.isSymmetric(matrix));
    }
}
