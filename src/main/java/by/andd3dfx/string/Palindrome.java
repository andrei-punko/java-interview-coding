package by.andd3dfx.string;

/*
A palindrome is a word that reads the same backward or forward.
Write a function that checks if a given word is a palindrome. Character case should be ignored.
For example, isPalindrome("Deleveled") should return true as character case should be ignored, resulting in "deleveled",
which is a palindrome since it reads the same backward and forward.
 */
public class Palindrome {

  public static boolean isPalindrome(String word) {
    if (word == null) {
      return false;
    }
    word = word.toLowerCase();

    for (int i = 0; i < word.length() / 2; i++) {
      if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static String removePalindromesFromString(String string) {
    String[] words = string.split("\\s");
    for (String word : words) {
      if (isPalindrome(word)) {
          string = string.replace(word, "");
      }
    }
    return string;
  }

  public static String removeNthPalindrome(String string, int n) {
      String[] words = string.split("\\s");
      int counter = 0;
      for (String word : words) {
          if (isPalindrome(word)) {
              counter++;
              if (counter == n) {
                  return string.replace(word, "");
              }
          }
      }
      return string;
  }

  public static void main(String[] args) {
    System.out.println(Palindrome.isPalindrome("Deleveled"));
  }
}
