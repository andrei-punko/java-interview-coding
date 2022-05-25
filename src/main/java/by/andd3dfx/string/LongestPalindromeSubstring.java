package by.andd3dfx.string;

/**
 * Given a string, find the longest substring which is palindrome.
 * <p>
 * For example,
 * Input: Given string : "forgeeksskeegfor",	Output: "geeksskeeg"
 * Input: Given string : "Geeks",				Output: "ee""
 */
public class LongestPalindromeSubstring {

    public static String find(String str) {
        var result = str.substring(0, 1);

        for (int i = 0; i < str.length(); i++) {
            for (int j = str.length() - 1; j >= i + result.length() + 1; j--) {
                var currentString = str.substring(i, j);
                if (currentString.length() > result.length() && checkIsPalindrome(currentString)) {
                    result = currentString;
                    continue;
                }
            }
        }

        return result;
    }

    static boolean checkIsPalindrome(String str) {
        var len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
