package by.andd3dfx.numeric;

/**
 * <pre>
 * Determine the greatest common divisor.
 * Based on "Stephens - Essential Algorithms":
 *   GCD(a, b) = GCD(b, a Mod b)
 *   GCD(a, 0) is a.
 * </pre>
 */
public class GreatestCommonDivisor {

    public static int determineUsingRecursion(int a, int b) {
        if (b == 0) {
            return a;
        }
        return determineUsingRecursion(b, a % b);
    }

    public static int determineUsingLoop(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
}
