package by.andd3dfx.search;

/**
 * <pre>
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example 1:
 *
 * Input: board = [
 *  ["A","B","C","E"],
 *  ["S","F","C","S"],
 *  ["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Example 2:
 *
 * Input: board = [
 *  ["A","B","C","E"],
 *  ["S","F","C","S"],
 *  ["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Example 3:
 *
 * Input: board = [
 *  ["A","B","C","E"],
 *  ["S","F","C","S"],
 *  ["A","D","E","E"]], word = "ABCB"
 * Output: false
 * </pre>
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        var m = board.length;
        var n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;

                    if (findNextCharacter(board, i, j, word, 1, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean findNextCharacter(char[][] board, int i, int j, String word, int pos, boolean[][] visited) {
        if (pos >= word.length()) {
            return true;
        }

        var m = board.length;
        var n = board[0].length;

        if (i > 0 && !visited[i - 1][j]) {
            if (checkIsCharacterSuitable(board, i - 1, j, word, pos)) {
                visited[i - 1][j] = true;
                if (findNextCharacter(board, i - 1, j, word, pos + 1, visited)) {
                    return true;
                }

                visited[i - 1][j] = false;
            }
        }
        if (j > 0 && !visited[i][j - 1]) {
            if (checkIsCharacterSuitable(board, i, j - 1, word, pos)) {
                visited[i][j - 1] = true;
                if (findNextCharacter(board, i, j - 1, word, pos + 1, visited)) {
                    return true;
                }

                visited[i][j - 1] = false;
            }
        }
        if (i < m - 1 && !visited[i + 1][j]) {
            if (checkIsCharacterSuitable(board, i + 1, j, word, pos)) {
                visited[i + 1][j] = true;
                if (findNextCharacter(board, i + 1, j, word, pos + 1, visited)) {
                    return true;
                }

                visited[i + 1][j] = false;
            }
        }
        if (j < n - 1 && !visited[i][j + 1]) {
            if (checkIsCharacterSuitable(board, i, j + 1, word, pos)) {
                visited[i][j + 1] = true;
                if (findNextCharacter(board, i, j + 1, word, pos + 1, visited)) {
                    return true;
                }

                visited[i][j + 1] = false;
            }
        }

        return false;
    }

    private boolean checkIsCharacterSuitable(char[][] board, int i, int j, String word, int pos) {
        return board[i][j] == word.charAt(pos);
    }
}
