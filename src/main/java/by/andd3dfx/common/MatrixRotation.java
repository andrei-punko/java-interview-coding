package by.andd3dfx.common;

import java.util.List;

/**
 * <pre>
 * https://www.hackerrank.com/challenges/matrix-rotation-algo/problem
 *
 * You are given a 2D matrix of dimension m*n and a positive integer r. You have to rotate the matrix times and
 * print the resultant matrix. Rotation should be in anti-clockwise direction.
 * It is guaranteed that the minimum of m and n will be even.
 *
 * As an example, rotate the Start matrix by 2:
 *
 *     Start         First           Second
 *      1 2 3 4       2  3  4  5      3  4  5  6
 *     12 1 2 5  ->   1  2  3  6 ->   2  3  4  7
 *     11 4 3 6      12  1  4  7      1  2  1  8
 *     10 9 8 7      11 10  9  8     12 11 10  9
 * </pre>
 */
public class MatrixRotation {

    public static void rotate(List<List<Integer>> matrix, int r) {
        int left = 0;
        int up = 0;

        int m = matrix.size();
        int n = matrix.get(0).size();

        while (m >= 1 && n >= 1) {
            int count = 2 * (m + n) - 4;
            int[] tmp = new int[count];
            int curr = 0;
            for (int i = 0; i < n; i++) {
                tmp[curr] = matrix.get(up).get(left + i);
                curr++;
            }
            for (int i = 1; i < m - 1; i++) {
                tmp[curr] = matrix.get(up + i).get(left + n - 1);
                curr++;
            }
            for (int i = n - 1; i >= 0; i--) {
                tmp[curr] = matrix.get(up + m - 1).get(left + i);
                curr++;
            }
            for (int i = m - 2; i >= 1; i--) {
                tmp[curr] = matrix.get(up + i).get(left);
                curr++;
            }

            curr = r % count;
            if (r < 0) {
                curr += count;
            }

            for (int i = 0; i < n; i++) {
                matrix.get(up).set(left + i, tmp[curr]);
                curr++;
                if (curr >= count) {
                    curr -= count;
                }
            }
            for (int i = 1; i < m - 1; i++) {
                matrix.get(up + i).set(left + n - 1, tmp[curr]);
                curr++;
                if (curr >= count) {
                    curr -= count;
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                matrix.get(up + m - 1).set(left + i, tmp[curr]);
                curr++;
                if (curr >= count) {
                    curr -= count;
                }
            }
            for (int i = m - 2; i >= 1; i--) {
                matrix.get(up + i).set(left, tmp[curr]);
                curr++;
                if (curr >= count) {
                    curr -= count;
                }
            }

            m -= 2;
            n -= 2;

            left++;
            up++;
        }
    }
}
