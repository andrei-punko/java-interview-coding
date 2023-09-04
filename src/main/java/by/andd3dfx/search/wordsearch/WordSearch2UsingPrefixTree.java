package by.andd3dfx.search.wordsearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

/**
 * <pre>
 * https://leetcode.com/problems/word-search-ii/
 *
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
public class WordSearch2UsingPrefixTree implements IWordSearch2 {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static class Trie {
        private String value;
        private boolean isKey;
        private final Map<Character, Trie> children = new HashMap<>();

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Trie());
        }

        public Trie getChild(char ch) {
            return children.get(ch);
        }

        public void insert(String word) {
            var node = this;
            for (var ch : word.toCharArray()) {
                if (!node.hasChild(ch)) {
                    node.addChild(ch);
                }
                node = node.getChild(ch);
            }
            node.value = word;
            node.isKey = true;
        }

        @Override
        public String toString() {
            StringJoiner sj = new StringJoiner(",");
            if (value != null) {
                sj.add("\"key\": \"%s\"".formatted(isKey));
                sj.add("\"v\": \"%s\"".formatted(value));
            }
            for (var key : children.keySet()) {
                sj.add("\"%s\": %s".formatted(key, children.get(key)));
            }
            return "{" + sj + "}";
        }
    }

    @Override
    public List<String> findWords(char[][] board, String[] words) {
        // Build prefix tree
        Trie trie = new Trie();
        Arrays.stream(words).forEach(trie::insert);

        System.out.println(prettyPrint(trie));

        // Use a prefix tree to determine result
        Set<String> result = new HashSet<>();
        var m = board.length;
        var n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                visited[i][j] = true;

                traverse(board, i, j, trie, visited, result);
            }
        }

        return result.stream().toList();
    }

    private void traverse(char[][] board, int i, int j, Trie trie, boolean[][] visited, Set<String> result) {
        var ch = board[i][j];
        if (trie.hasChild(ch)) {
            var child = trie.getChild(ch);
            if (child.isKey) {
                result.add(child.value);
            }

            checkNewPos(board, i - 1, j, child, visited, result);
            checkNewPos(board, i, j - 1, child, visited, result);
            checkNewPos(board, i + 1, j, child, visited, result);
            checkNewPos(board, i, j + 1, child, visited, result);
        }
    }

    private void checkNewPos(char[][] board, int i, int j, Trie trie, boolean[][] visited, Set<String> result) {
        var m = board.length;
        var n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }

        if (!visited[i][j]) {
            if (trie.isKey) {
                result.add(trie.value);
            }

            visited[i][j] = true;
            traverse(board, i, j, trie, visited, result);
            visited[i][j] = false;
        }
    }

    @SneakyThrows
    public static String prettyPrint(Object object) {
        var uglyString = String.valueOf(object);

        Object jsonObject = objectMapper.readValue(uglyString, Object.class);

        return objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonObject);
    }
}
