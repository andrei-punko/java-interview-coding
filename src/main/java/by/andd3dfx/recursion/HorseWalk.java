package by.andd3dfx.recursion;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class HorseWalk {

    public class Solution {
        final boolean isFound;
        final boolean[][] cellsTaken;
        final Stack<String> log;

        public Solution(boolean isFound, boolean[][] cellsTaken, Stack<String> log) {
            this.isFound = isFound;
            this.cellsTaken = cellsTaken;
            this.log = log;
        }
    }

    public Solution solve(int boardSize) {
        boolean[][] cellsTaken = new boolean[boardSize][boardSize];
        cellsTaken[0][0] = true;

        Stack<String> log = new Stack<>();
        log.push(convertToCheckMateCoordinateSystem(0, 0));

        boolean isFound = checkSolution(boardSize, cellsTaken, 1, 0, 0, log);

        return new Solution(isFound, cellsTaken, log);
    }

    public boolean checkSolution(int size, boolean[][] cellsTaken, int cellsVisited, int currX, int currY, Stack<String> log) {
        if (cellsVisited == size * size) {
            return true;
        }

        final int[][] moves = {{-2, -1}, {-2, 1}, {2, 1}, {2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
        for (int i = 0; i < 8; i++) {
            int row = currX + moves[i][0];
            int col = currY + moves[i][1];
            if (row < 0 || row >= size || col < 0 || col >= size) {
                continue;
            }

            if (!cellsTaken[row][col]) {
                cellsTaken[row][col] = true;

                log.push(convertToCheckMateCoordinateSystem(row, col));
                if (checkSolution(size, cellsTaken, cellsVisited + 1, row, col, log)) {
                    return true;
                } else {
                    log.pop();
                    cellsTaken[row][col] = false;
                }
            }
        }
        return false;
    }

    private String convertToCheckMateCoordinateSystem(int row, int col) {
        final char[] chars = "abcdefgh".toCharArray();
        return String.format("%s%d", chars[col], row + 1);
    }
}
