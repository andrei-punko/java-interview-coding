package by.andd3dfx.search;

public class WordSearch2UsingWordSearch1Test extends AbstractWordSearch2Test {

    @Override
    protected IWordSearch2 initiate() {
        return new WordSearch2UsingWordSearch1();
    }
}