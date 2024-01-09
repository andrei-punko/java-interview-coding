package by.andd3dfx.search;

/**
 * <pre>
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
 *
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
 * return the number of negative numbers in grid.
 *
 * Example 1:
 * Input: grid = [
 *      [4,3,2,-1],
 *      [3,2,1,-1],
 *      [1,1,-1,-2],
 *      [-1,-1,-2,-3]
 *  ]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 *
 * Example 2:
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 *
 * Follow up: Could you find an O(n + m) solution?
 * </pre>
 */
public class CountNegativesInSortedMatrix {

    public static int count_MN(int[][] grid) {
        var m = grid.length;
        if (m == 0) {
            return 0;
        }
        var n = grid[0].length;
        var result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public static int count_MNOptimized(int[][] grid) {
        var m = grid.length;
        if (m == 0) {
            return 0;
        }
        var n = grid[0].length;
        var result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    result += n - j;    // add count of numbers from current to the end of row (because of sorted row)
                    break;
                }
            }
        }
        return result;
    }

    public static int count_NPlusM(int[][] grid) {
        var m = grid.length;
        if (m == 0) {
            return 0;
        }
        var n = grid[0].length;
        var result = 0;

        // start position in the left bottom grid corner
        var i = m - 1;
        var j = 0;

        while (i >= 0 && j < n) {
            if (grid[i][j] < 0) {
                i--;                // switch to the upper row
                result += n - j;    // add count of numbers from current to the end of row (because of sorted row)
            } else {
                j++;                // switch to the right column
            }
        }
        return result;
    }
}
