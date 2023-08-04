package by.andd3dfx.string.boyermoore;

public class FindSubstring implements IFindSubstring {

    @Override
    public int indexOf(String text, String pattern) {
        int textLen = text.length();
        int patternLen = pattern.length();
        var counter = new Counter();

        outerLoop:
        for (int i = 0; i <= textLen - patternLen; i++) {
            for (int pos = 0; pos < patternLen; pos++) {
                if (isNotMatched(text, i + pos, pattern, pos, counter)) {
                    continue outerLoop;
                }
            }

            System.out.println("Comparisons: " + counter.get());
            return i;
        }

        System.out.println("Comparisons: " + counter.get());
        return -1;
    }
}
