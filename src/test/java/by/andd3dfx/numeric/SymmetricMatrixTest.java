package by.andd3dfx.numeric;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SymmetricMatrixTest {

    @Test
    public void checkIsSymmetricPositive() {
        int[][] matrix = {
                {0, 1, 2},
                {1, 2, 3},
                {2, 3, 4}
        };

        boolean result = SymmetricMatrix.checkIsSymmetric(3, matrix);

        assertTrue(result);
    }

    @Test
    public void checkIsSymmetricNegative() {
        int[][] matrix = {
                {0, 1, 5},
                {1, 2, 3},
                {2, 3, 4}
        };

        boolean result = SymmetricMatrix.checkIsSymmetric(3, matrix);

        assertFalse(result);
    }
}
