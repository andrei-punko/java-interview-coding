package by.andd3dfx.search;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordSearch2Test {

    private WordSearch2 wordSearch;

    @Before
    public void setUp() throws Exception {
        wordSearch = new WordSearch2();
    }

    @Test
    public void exist_1x2() {
        var board = new char[][]{
                {'A', 'B'},
        };
        var words = new String[]{"BA", "AA", "AB"};
        var expectedWords = new String[]{"BA", "AB"};

        findWordAndCheckAsserts(board, words, expectedWords);
    }

    @Test
    public void exist_2x2() {
        var board = new char[][]{
                {'A', 'B'},
                {'C', 'D'},
        };
        var words = new String[]{"ABD", "ADC", "BDC", "DCAB", "DBA", "BCD", "BC", "CA"};
        var expectedWords = new String[]{"ABD", "BDC", "DCAB", "DBA", "CA"};

        findWordAndCheckAsserts(board, words, expectedWords);
    }

    @Test
    public void exist_4x4() {
        var board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        var words = new String[]{"ABCCED", "SFCCE", "SCEEE", "SCEDFB", "SECCEE", "FDA", "FDEES", "CSEEE"};
        var expectedWords = new String[]{"ABCCED", "SFCCE", "SCEDFB", "SECCEE", "FDA", "FDEES"};

        findWordAndCheckAsserts(board, words, expectedWords);
    }

    private void findWordAndCheckAsserts(char[][] board, String[] words, String[] expectedWords) {
        var result = wordSearch.findWords(board, words);

        assertThat(result).hasSize(expectedWords.length);
        assertThat(result).containsExactlyInAnyOrder(expectedWords);
    }
}
