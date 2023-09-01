package by.andd3dfx.search;

import java.util.Arrays;
import java.util.List;

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
public class WordSearch2UsingWordSearch1 implements IWordSearch2 {

    private final WordSearch wordSearch = new WordSearch();

    @Override
    public List<String> findWords(char[][] board, String[] words) {
        return Arrays.stream(words)
                .filter(word -> wordSearch.exist(board, word))
                .toList();
    }
}
