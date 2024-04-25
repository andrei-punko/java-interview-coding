package by.andd3dfx.search.wordsearch;

public class WordSearch_IIUsingWordSearchTest extends AbstractWordSearch_IITest {

    @Override
    protected IWordSearch_II initiate() {
        return new WordSearch_IIUsingWordSearch();
    }
}
