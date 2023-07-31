package by.andd3dfx.string;

public class FindSubstringBoyerMooreTest extends AbstractFindSubstringTest {

    @Override
    public int indexOf(String text, String pattern) {
        return FindSubstring.indexOf_BoyerMoore(text, pattern);
    }
}
