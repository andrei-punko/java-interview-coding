package by.andd3dfx.search.wordsearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void exist_allCharsUsed() {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        var word = "ASABFDECCESE";

        assertTrue(wordSearch.exist(board, word));
    }
}
