package by.andd3dfx.dynamic;

import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;

/**
 * <pre>
 * <a href="https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/?ref=lbp">Task description</a>
 *
 * Given a value V, if we want to make a change for V cents, and we have an infinite supply of each of
 * C = { C1, C2, .., Cm} valued coins, what is the minimum number of coins to make the change?
 * If it’s not possible to make a change, print -1.
 *
 * Examples:
 *     Input: coins[] = {25, 10, 5}, V = 30
 *     Output: Minimum 2 coins required. We can use one coin of 25 cents and one of 5 cents
 *
 *     Input: coins[] = {9, 6, 5, 1}, V = 11
 *     Output: Minimum 2 coins required. We can use one coin of 6 cents and 1 coin of 5 cents
 * </pre>
 *
 * @see <a href="https://youtu.be/K1xPbYPslRU">Video solution</a>
 */
public class ChangeWithMinNumberOfCoins {

    public static int determine_usingRecursion(int[] coins, int amount) {
        Arrays.sort(coins);
        var result = innerRecursion(coins, amount);

        if (result == MAX_VALUE) {
            return -1;
        }
        return result;
    }

    private static int innerRecursion(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int result = MAX_VALUE;
        for (var coin : coins) {

            // Go through all coins smaller or equals to `amount`
            if (amount >= coin) {
                int subResult = innerRecursion(coins, amount - coin);

                // Check for INT_MAX to avoid overflow and see if a result can be minimized
                if (subResult != MAX_VALUE && subResult + 1 < result) {
                    result = subResult + 1;
                }
            }
        }

        return result;
    }

    public static int determine_usingMemoization(int[] coins, int amount) {
        // The minCoins[i] will be storing the minimum number of coins required for `i` value.
        // So minCoins[amount] will have a result
        int[] minCoins = new int[amount + 1];

        Arrays.fill(minCoins, MAX_VALUE);
        minCoins[0] = 0;

        Arrays.sort(coins);

        // Compute minimum coins required for all values from 1 to `amount`
        for (int i = 1; i <= amount; i++) {

            for (var coin : coins) {
                // Go through all coins smaller or equals to `i`
                if (i - coin >= 0) {
                    int subResult = minCoins[i - coin];

                    if (subResult != MAX_VALUE && subResult + 1 < minCoins[i]) {
                        minCoins[i] = subResult + 1;
                    }
                }
            }
        }

        if (minCoins[amount] == MAX_VALUE) {
            return -1;
        }

        return minCoins[amount];
    }
}
