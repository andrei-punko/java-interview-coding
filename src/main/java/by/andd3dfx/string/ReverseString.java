package by.andd3dfx.string;

public class ReverseString {

    public static String apply(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            swap(chars, i, chars.length - 1 - i);
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        var tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
