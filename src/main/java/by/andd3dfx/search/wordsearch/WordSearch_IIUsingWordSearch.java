package by.andd3dfx.search.wordsearch;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/word-search-ii/">Task description</a>
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
 *
 * @see <a href="https://youtu.be/DTyMyr6bNGw">Video solution</a>
 */
public class WordSearch_IIUsingWordSearch implements IWordSearch_II {

    private final WordSearch wordSearch = new WordSearch();

    @Override
    public List<String> findWords(char[][] board, String[] words) {
        return Arrays.stream(words)
                .filter(word -> wordSearch.exist(board, word))
                .toList();
    }
}
