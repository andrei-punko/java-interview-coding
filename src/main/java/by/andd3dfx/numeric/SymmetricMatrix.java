package by.andd3dfx.numeric;

/**
 * Symmetric matrix.
 * Given the number n, not exceeding 10, and a matrix of size n × n.
 * <p>
 * Check whether this matrix is symmetric in relation to the main diagonal. Output the word “YES”, if it's symmetric and the word “NO” otherwise.
 * <p>
 * 3
 * 0 1 2
 * 1 2 3
 * 2 3 4
 */
public class SymmetricMatrix {

    public static boolean checkIsSymmetric(int n, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2},
                {1, 2, 3},
                {2, 3, 4}
        };

        boolean result = SymmetricMatrix.checkIsSymmetric(3, matrix);

        System.out.printf("result = " + (result ? "YES" : "NO"));
    }
}
