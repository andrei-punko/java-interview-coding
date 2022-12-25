package by.andd3dfx.recursion;

import lombok.AllArgsConstructor;

import java.util.Stack;

/**
 * Find solution for Horse Walk task: horse should visit each cell of NxN board one time
 */
public class HorseWalk {

    @AllArgsConstructor
    public class Solution {
        final boolean isFound;
        final boolean[][] cellsTaken;
        final Stack<String> log;
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
        for (int i = 0; i < moves.length; i++) {
            int nextX = currX + moves[i][0];
            int nextY = currY + moves[i][1];
            if (nextX < 0 || nextX >= size || nextY < 0 || nextY >= size) {
                continue;
            }

            if (!cellsTaken[nextX][nextY]) {
                cellsTaken[nextX][nextY] = true;

                log.push(convertToCheckMateCoordinateSystem(nextX, nextY));
                if (checkSolution(size, cellsTaken, cellsVisited + 1, nextX, nextY, log)) {
                    return true;
                } else {
                    log.pop();
                    cellsTaken[nextX][nextY] = false;
                }
            }
        }
        return false;
    }

    private final char[] CHARS = "abcdefgh".toCharArray();

    private String convertToCheckMateCoordinateSystem(int row, int col) {
        return String.format("%s%d", CHARS[col], row + 1);
    }
}
