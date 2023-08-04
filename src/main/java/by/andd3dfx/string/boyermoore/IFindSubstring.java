package by.andd3dfx.string.boyermoore;

public interface IFindSubstring {

    int indexOf(String text, String pattern);

    default boolean isMatched(String str1, int pos1, String str2, int pos2, Counter counter) {
        counter.inc();
        return str1.charAt(pos1) == str2.charAt(pos2);
    }

    default boolean isNotMatched(String str1, int pos1, String str2, int pos2, Counter counter) {
        return !isMatched(str1, pos1, str2, pos2, counter);
    }
}
