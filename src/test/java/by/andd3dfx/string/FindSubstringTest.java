package by.andd3dfx.string;

public class FindSubstringTest extends AbstractFindSubstringTest {

    @Override
    public int indexOf(String text, String pattern) {
        return FindSubstring.indexOf(text, pattern);
    }
}
