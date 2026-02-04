package by.andd3dfx.string;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/description/">Task description</a>
 *
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 *   Input: s = "Let's take LeetCode contest"
 *   Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Example 2:
 *   Input: s = "Mr Ding"
 *   Output: "rM gniD"
 * </pre>
 *
 * @see <a href="https://youtu.be/gwQfBcIDa7s">Video solution</a>
 */
public class ReverseWordsInAStringIII {

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = reverse(words[i]);
        }
        return String.join(" ", words);
    }

    private static String reverse(String word) {
        var chars = word.toCharArray();
        var n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            swap(chars, i, n - 1 - i);
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        var tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
