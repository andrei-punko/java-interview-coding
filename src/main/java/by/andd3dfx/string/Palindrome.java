package by.andd3dfx.string;

import java.util.HashSet;
import java.util.Set;

public class Palindrome {

  /**
   * A palindrome is a word that reads the same backward or forward.
   * Write a function that checks if a given word is a palindrome.
   */
  public static boolean isPalindrome(String word) {
    return isPalindrome(word, false);
  }

  /**
   * A palindrome is a word that reads the same backward or forward. Write a function that checks if a given word is a
   * palindrome. Character case should be ignored. For example, isPalindrome("Deleveled") should return true as
   * character case should be ignored, resulting in "deleveled", which is a palindrome since it reads the same
   * backward and forward.
   */
  public static boolean isPalindromeIgnoreCase(String word) {
    return isPalindrome(word, true);
  }

  private static boolean isPalindrome(String word, boolean ignoreCase) {
    if (word == null) {
      return false;
    }
    if (ignoreCase) {
        word = word.toLowerCase();
    }

    for (int i = 0; i < word.length() / 2; i++) {
      if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Remove palindromes from string.
   */
  public static String removePalindromes(String string) {
    String[] words = string.split(",?\\s");
    for (String word : words) {
      if (isPalindromeIgnoreCase(word)) {
          string = string.replace(word, "");
      }
    }
    return string
            .replaceAll("(,\\s){2,}", ", ")
            .replaceAll("\\s{2,}", " ")
            .trim();
  }

  /**
   * Remove Nth palindrome from string.
   */
  public static String removeNthPalindrome(String string, int n) {
      String[] words = string.split(",?\\s");
      int counter = 0;
      for (String word : words) {
          if (isPalindromeIgnoreCase(word)) {
              counter++;
              if (counter == n) {
                  return string
                          .replace(word, "")
                          .replaceAll("(,\\s){2,}", ", ")
                          .replaceAll("\\s{2,}", " ")
                          .trim();
              }
          }
      }
      return string;
  }

  /**
   * <pre>
   * Given a string, find the longest substring which is palindrome.
   * For example:
   * Input: "forgeeksskeegfor",	Output: "geeksskeeg"
   * Input: "Geeks",			Output: "ee""
   * </pre>
   */
  public static String longestPalindromeSubstring(String str) {
      var result = str.substring(0, 1);

      for (int i = 0; i < str.length(); i++) {
          for (int j = str.length() - 1; j >= i + result.length() + 1; j--) {
              var currentString = str.substring(i, j);
              if (currentString.length() > result.length() && isPalindrome(currentString)) {
                  result = currentString;
              }
          }
      }

      return result;
  }

    /**
     * Дана строка. Написать метод, проверяющий, можно ли перестановкой букв данной строки сформировать палиндром.
     */
    public static boolean canFormPalindrome(String str) {
        /**
         * Идея решения в том, что в палиндроме все символы встречаются четное кол-во раз, кроме, максимум одного символа.
         * Убеждаемся, что таких одиночных символов не более одного.
         */
        Set set = new HashSet();
        for (var ch : str.toCharArray()) {
            if (!set.contains(ch)) {
                set.add(ch);
            } else {
                set.remove(ch);
            }
        }

        return set.size() <= 1;
    }
}
