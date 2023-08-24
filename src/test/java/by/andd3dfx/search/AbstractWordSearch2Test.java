package by.andd3dfx.search;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractWordSearch2Test {

    private IWordSearch2 wordSearch2;

    @Before
    public void setUp() throws Exception {
        wordSearch2 = initiate();
    }

    protected abstract IWordSearch2 initiate();

    @Test
    public void exist_1x2() {
        var board = new char[][]{
                {'A', 'B'},
        };
        var words = new String[]{"AB", "ABC", "BA", "AA", "B"};
        var expectedWords = new String[]{"AB", "BA", "B"};

        findWordAndCheckAsserts(board, words, expectedWords);
    }

    @Test
    public void exist_2x2() {
        var board = new char[][]{
                {'A', 'B'},
                {'C', 'D'},
        };
        var words = new String[]{"ABD", "ADC", "BDC", "DCAB", "DBA", "BCD", "D", "BC", "CA"};
        var expectedWords = new String[]{"ABD", "BDC", "DCAB", "DBA", "D", "CA"};

        findWordAndCheckAsserts(board, words, expectedWords);
    }

    @Test
    public void exist_4x4() {
        var board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        var words = new String[]{"ABCCED", "SFCCE", "SCEEE", "FC", "SCEDFB", "SECCEE", "FDA", "FDEES", "CSEEE"};
        var expectedWords = new String[]{"ABCCED", "SFCCE", "FC", "SCEDFB", "SECCEE", "FDA", "FDEES"};

        findWordAndCheckAsserts(board, words, expectedWords);
    }

    private void findWordAndCheckAsserts(char[][] board, String[] words, String[] expectedWords) {
        var result = wordSearch2.findWords(board, words);

        assertThat(result).hasSize(expectedWords.length);
        assertThat(result).containsExactlyInAnyOrder(expectedWords);
    }
}
