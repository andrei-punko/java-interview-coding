package by.andd3dfx.search;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <pre>
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
 * or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * Example 1:
 *
 * Input: board = [
 *  ["o","a","a","n"],
 *  ["e","t","a","e"],
 *  ["i","h","k","r"],
 *  ["i","f","l","v"]
 * ], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 *
 * Example 2:
 *
 * Input: board = [
 *  ["a","b"],
 *  ["c","d"]
 * ], words = ["abcb"]
 * Output: []
 * </pre>
 */
public class WordSearch2 {

    private long recursionCallCounter = 0L;

    @Data
    @AllArgsConstructor
    public static class Context {
        private char[][] board;
        private Set<String> wordsToFind;
        private int maxLen;
        private Set<String> wordsFound;

        public int m() {
            return board.length;
        }

        public int n() {
            return board[0].length;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        var wordsToFind = Arrays.stream(words).collect(Collectors.toSet());
        int maxLen = Arrays.stream(words)
                .map(String::length)
                .max(Integer::compareTo)
                .orElse(-1);
        var resultWordsSet = new HashSet<String>();
        var ctx = new Context(board, wordsToFind, maxLen, resultWordsSet);

        for (int i = 0; i < ctx.m(); i++) {
            for (int j = 0; j < ctx.n(); j++) {
                var visited = new boolean[ctx.m()][ctx.n()];

                examine(i, j, "", visited, ctx);
            }
        }

        System.out.println(recursionCallCounter);
        return resultWordsSet.stream().toList();
    }

    public void examine(int i, int j, String str, boolean[][] visited, Context ctx) {
        recursionCallCounter++;

        if (i < 0 || j < 0 || i >= ctx.m() || j >= ctx.n()) {
            return;
        }
        if (visited[i][j] || str.length() >= ctx.maxLen) {
            return;
        }
        if (allWordsToFindAreNotStartedWithPrefix(ctx.wordsToFind, str)) {
            return;
        }

        visited[i][j] = true;
        str += ctx.board[i][j];
        if (ctx.wordsToFind.contains(str)) {
            ctx.wordsFound.add(str);
        }

        examine(i - 1, j, str, visited, ctx);
        examine(i + 1, j, str, visited, ctx);
        examine(i, j - 1, str, visited, ctx);
        examine(i, j + 1, str, visited, ctx);

        visited[i][j] = false;
    }

    private boolean allWordsToFindAreNotStartedWithPrefix(Set<String> wordsToFind, String prefix) {
        for (var word : wordsToFind) {
            if (word.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}
