package by.andd3dfx.string;

/**
 * Implement the function: take the str parameter being passed and modify it using the following algorithm.
 * Replace every letter in the string with the letter following it in the alphabet (i.e. c becomes d, z becomes a).
 * Then capitalize every vowel in this new string (a, e, i, o, u) and finally return this modified string.
 */
public class ShiftCharactersAndCapitalizeVowels {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String VOWELS = "aeiou";

    public static String apply(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = ALPHABET.indexOf(c);
            if (index != -1) {
                index = (index + 1) % ALPHABET.length();
                chars[i] = capitalizeVowel(ALPHABET.charAt(index));
            }
        }
        return new String(chars);
    }

    private static char capitalizeVowel(char c) {
        if (VOWELS.indexOf(c) != -1) {
            return Character.toUpperCase(c);
        }
        return c;
    }
}
