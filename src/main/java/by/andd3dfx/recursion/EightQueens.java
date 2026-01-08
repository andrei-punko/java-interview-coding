package by.andd3dfx.recursion;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Place N Queens to NxN board
 * <p>
 * Used Rod Stephens - 'Essential Algorithms' book
 *
 * @see <a href="https://youtu.be/v9kctJiD4KQ">Video solution</a>
 */
public class EightQueens {

    @Data
    @AllArgsConstructor
    public static class Solution {

        private boolean isFound;
        private boolean[][] cellsTaken;

        public int[][] prettyPrint() {
            int size = cellsTaken.length;
            int[][] result = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    result[i][j] = cellsTaken[i][j] ? 1 : 0;
                }
            }
            return result;
        }
    }

    public Solution solve(int boardSize) {
        boolean[][] cellsTaken = new boolean[boardSize][boardSize];
        boolean isSolutionFound = checkSolution(boardSize, cellsTaken, 0);

        return new Solution(isSolutionFound, cellsTaken);
    }

    private boolean checkSolution(int size, boolean[][] cellsTaken, int positionedQueensAmount) {
        if (!isLegal(size, cellsTaken)) {
            return false;
        }
        if (positionedQueensAmount == size) {
            return true;
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (!cellsTaken[row][col]) {
                    cellsTaken[row][col] = true;

                    if (checkSolution(size, cellsTaken, positionedQueensAmount + 1)) {
                        return true;
                    } else {
                        cellsTaken[row][col] = false;
                    }
                }
            }
        }
        return false;
    }

    boolean isLegal(int size, boolean[][] cellsTaken) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cellsTaken[i][j]) {
                    // check rows
                    for (int r = 1; r < size; r++) {
                        if (i + r < size && cellsTaken[i + r][j]) {
                            return false;
                        }
                        if (i - r >= 0 && cellsTaken[i - r][j]) {
                            return false;
                        }
                    }

                    // check columns
                    for (int r = 1; r < size; r++) {
                        if (j + r < size && cellsTaken[i][j + r]) {
                            return false;
                        }
                        if (j - r >= 0 && cellsTaken[i][j - r]) {
                            return false;
                        }
                    }

                    // check diagonals
                    for (int r = 1; r < size; r++) {
                        if (i + r < size && j + r < size && cellsTaken[i + r][j + r]) {
                            return false;
                        }
                        if (i + r < size && j - r >= 0 && cellsTaken[i + r][j - r]) {
                            return false;
                        }
                        if (i - r >= 0 && j + r < size && cellsTaken[i - r][j + r]) {
                            return false;
                        }
                        if (i - r >= 0 && j - r >= 0 && cellsTaken[i - r][j - r]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
