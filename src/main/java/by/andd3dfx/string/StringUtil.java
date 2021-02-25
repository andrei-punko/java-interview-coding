package by.andd3dfx.string;

public class StringUtil {

    public static String revert(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char c = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = c;
        }
        return new String(chars);
    }

    /**
     * Using the Java language, have the function LetterChanges(str) take the str parameter being passed and modify it
     * using the following algorithm. Replace every letter in the string with the letter following it in the alphabet
     * (ie. c becomes d, z becomes a). Then capitalize every vowel in this new string (a, e, i, o, u) and finally return
     * this modified string.
     */
    public static String shiftCharactersAndCapitalizeVowels(String str) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = alphabet.indexOf(c);
            if (index != -1) {
                index = (index + 1) % alphabet.length();
                result += capitalizeVowel(alphabet.charAt(index));
            } else {
                result += c;
            }
        }
        return result;
    }

    private static String capitalizeVowel(char c) {
        final String vowels = "aeiou";
        char[] chars = {c};
        if (vowels.indexOf(c) != -1) {
            return new String(chars).toUpperCase();
        }
        return new String(chars);
    }
}
