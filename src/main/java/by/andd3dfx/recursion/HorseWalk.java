package by.andd3dfx.recursion;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Find solution for Horse Walk task: horse should visit each cell of NxN board one time
 *
 * @see <a href="https://youtu.be/keNYNcQi9o8">Video solution</a>
 */
public class HorseWalk {

    @AllArgsConstructor
    @Data
    public static class Cell {
        private static final char[] CHARS = "abcdefgh".toCharArray();

        private int x, y;

        public String convertToCheckMateCoordinateSystem() {
            return String.format("%s%d", CHARS[x], y + 1);
        }
    }

    @Data
    @AllArgsConstructor
    public static class Solution {
        private final boolean isSolutionFound;
        private final boolean[][] cellsTaken;
        private final Deque<Cell> log;

        public String logToString() {
            var size = cellsTaken.length;
            if (!isSolutionFound || log.size() != size * size) {
                throw new IllegalStateException("The solution is still not found!");
            }

            int[][] board = new int[size][size];
            int positionNumber = 0;
            for (Cell cell : log.stream().toList()) {
                positionNumber++;
                board[cell.x][cell.y] = positionNumber;
            }

            StringBuilder sb = new StringBuilder();
            for (var x = 0; x < size; x++) {
                for (var y = 0; y < size; y++) {
                    sb.append(board[x][y]).append("\t");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    public Solution solve(int boardSize) {
        boolean[][] cellsTaken = new boolean[boardSize][boardSize];
        cellsTaken[0][0] = true;

        Deque<Cell> log = new ArrayDeque<>();
        log.push(new Cell(0, 0));

        boolean isSolutionFound = checkSolution(boardSize, cellsTaken, 1, 0, 0, log);

        return new Solution(isSolutionFound, cellsTaken, log);
    }

    public boolean checkSolution(int size, boolean[][] cellsTaken, int visitedCellsAmount, int currX, int currY, Deque<Cell> log) {
        if (visitedCellsAmount == size * size) {
            return true;
        }

        final int[][] POSSIBLE_MOVES = {{-2, -1}, {-2, 1}, {2, 1}, {2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
        for (var move : POSSIBLE_MOVES) {
            int nextX = currX + move[0];
            int nextY = currY + move[1];
            if (nextX < 0 || nextX >= size || nextY < 0 || nextY >= size) {
                continue;
            }

            if (cellsTaken[nextX][nextY]) {
                continue;
            }

            cellsTaken[nextX][nextY] = true;
            log.push(new Cell(nextX, nextY));

            if (checkSolution(size, cellsTaken, visitedCellsAmount + 1, nextX, nextY, log)) {
                return true;
            } else {
                log.pop();
                cellsTaken[nextX][nextY] = false;
            }
        }
        return false;
    }
}
