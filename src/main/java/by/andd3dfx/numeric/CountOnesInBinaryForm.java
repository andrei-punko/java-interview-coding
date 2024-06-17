package by.andd3dfx.numeric;

/**
 * Count ones in binary form of number
 *
 * @see <a href="https://youtu.be/F8zwvJYw0R8">Video solution</a>
 */
public class CountOnesInBinaryForm {

    /**
     * 0b100011 -> 0b10001 -> 0b1000 -> 0b100 -> ... -> 0
     */
    public static int count(int num) {
        int result = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                result++;
            }
            num = num >> 1;
        }
        return result;
    }
}
