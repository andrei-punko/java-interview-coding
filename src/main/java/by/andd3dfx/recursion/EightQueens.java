package by.andd3dfx.recursion;

/**
 * Place N queens to NxN board
 * <p>
 * Used Rod Stephens - 'Essential Algorithms' book
 */
public class EightQueens {

    public class Solution {
        boolean isFound;
        boolean[][] cellsTaken;

        public Solution(boolean isFound, boolean[][] cellsTaken) {
            this.isFound = isFound;
            this.cellsTaken = cellsTaken;
        }
    }

    public Solution solve(int boardSize) {
        boolean[][] cellsTaken = new boolean[boardSize][boardSize];

        boolean isFound = checkSolution(boardSize, cellsTaken, 0);

        return new Solution(isFound, cellsTaken);
    }

    public boolean checkSolution(int size, boolean[][] cellsTaken, int queensPositioned) {
        if (!isLegal(size, cellsTaken)) {
            return false;
        }

        if (queensPositioned == size) {
            return true;
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (!cellsTaken[row][col]) {
                    cellsTaken[row][col] = true;

                    if (checkSolution(size, cellsTaken, queensPositioned + 1)) {
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
