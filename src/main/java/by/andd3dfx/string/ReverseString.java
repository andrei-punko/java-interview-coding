package by.andd3dfx.string;

/**
 * Reverse given string of characters
 *
 * @see <a href="https://youtu.be/BaFfp9zV6CM">Video solution</a>
 */
public class ReverseString {

    public static String apply(String str) {
        char[] chars = str.toCharArray();
        var left = 0;
        var right = chars.length - 1;

        while (left < right) {
            swap(chars, left, right);
            left++;
            right--;
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        var tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
