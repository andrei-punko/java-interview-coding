package by.andd3dfx.string;

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
