package by.andd3dfx.search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <pre>
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
public class WordSearchTest {

    private WordSearch wordSearch;

    @Before
    public void setUp() throws Exception {
        wordSearch = new WordSearch();
    }

    @Test
    public void exist() {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        var word = "ABCCED";

        assertTrue(wordSearch.exist(board, word));
    }

    @Test
    public void exist_startNotFromLeftRightCorner_multipleWrongPaths() {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        var word = "SEE";

        assertTrue(wordSearch.exist(board, word));
    }

    @Test
    public void exist_preventCharsReUsage() {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        var word = "ABCB";

        assertFalse(wordSearch.exist(board, word));
    }

    @Test
    public void exist_checkConnectivity() {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        var word = "ABCD";

        assertFalse(wordSearch.exist(board, word));
    }
}
