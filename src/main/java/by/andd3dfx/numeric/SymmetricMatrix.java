package by.andd3dfx.numeric;

/**
 * <pre>
 * Symmetric matrix.
 * Given the number n, not exceeding 10, and a matrix of size n × n.
 *
 * Check whether this matrix is symmetric in relation to the main diagonal.
 *
 * Symmetric:       Non-Symmetric:
 * 0 1 7            0 1 7
 * 1 2 3            1 2 5
 * 7 3 4            7 3 4
 * </pre>
 *
 * @see <a href="https://youtu.be/DwLLrRRPFkw">Video solution</a>
 */
public class SymmetricMatrix {

    public static boolean isSymmetric(int[][] matrix) {
        var size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
