package by.andd3dfx.string.boyermoore;

public class FindSubstringBoyerMooreTest extends AbstractFindSubstringTest {

    @Override
    protected IFindSubstring initiate() {
        return new FindSubstringBoyerMoore();
    }
}
