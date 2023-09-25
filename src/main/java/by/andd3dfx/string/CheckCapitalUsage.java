package by.andd3dfx.string;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

/**
 * <pre>
 * https://leetcode.com/problems/detect-capital/description/
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 *     All letters in this word are capitals, like "USA".
 *     All letters in this word are not capitals, like "leetcode".
 *     Only the first letter in this word is capital, like "Google".
 *
 * Given a string word, return true if the usage of capitals in it is right.
 *
 * Example 1:
 *
 * Input: word = "USA"
 * Output: true
 *
 * Example 2:
 *
 * Input: word = "FlaG"
 * Output: false
 * </pre>
 */
public class CheckCapitalUsage {

    public boolean isCapitalUsedProperly(String word) {
        var uppercase = word.toUpperCase();
        var lowercase = word.toLowerCase();
        var onlyFirstLetterCapitalized = buildWordWithFirstLetterCapitalized(word);

        return new HashSet<>(List.of(uppercase, lowercase, onlyFirstLetterCapitalized))
                .contains(word);
    }

    private String buildWordWithFirstLetterCapitalized(String word) {
        var chars = word.toLowerCase().toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars);
    }

    private final static Pattern PATTERN = Pattern.compile("^([A-Z]*|[A-Z]?[a-z]*)$");

    public boolean isCapitalUsedProperly_withRegex(String word) {
        return PATTERN.matcher(word).find();
    }
}
