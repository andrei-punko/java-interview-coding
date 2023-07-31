package by.andd3dfx.string;

public class FindSubstringBoyerMooreEnhancedTest extends AbstractFindSubstringTest {

    @Override
    public int indexOf(String text, String pattern) {
        return FindSubstring.indexOf_BoyerMooreEnhanced(text, pattern);
    }
}
