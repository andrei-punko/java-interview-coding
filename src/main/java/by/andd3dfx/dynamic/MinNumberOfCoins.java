package by.andd3dfx.dynamic;

/**
 * <pre>
 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/?ref=lbp
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
 */
public class MinNumberOfCoins {

    public static int determine_usingRecursion(int coins[], int amount) {
        var result = recursion(coins, amount);

        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    private static int recursion(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;

        // Go through all coins smaller than `amount`
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                int subResult = recursion(coins, amount - coins[i]);

                // Check for INT_MAX to avoid overflow and see if a result can be minimized
                if (subResult != Integer.MAX_VALUE && subResult + 1 < result) {
                    result = subResult + 1;
                }
            }
        }

        return result;
    }

    public static int determine_usingMemoization(int coins[], int amount) {
        // The table[i] will be storing the minimum number of coins required for `i` value.
        // So table[amount] will have a result
        int table[] = new int[amount + 1];

        table[0] = 0;

        for (int i = 1; i <= amount; i++) {
            table[i] = Integer.MAX_VALUE;
        }

        // Compute minimum coins required for all values from 1 to `amount`
        for (int i = 1; i <= amount; i++) {
            // Go through all coins smaller than `i`
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int subResult = table[i - coins[j]];

                    if (subResult != Integer.MAX_VALUE && subResult + 1 < table[i]) {
                        table[i] = subResult + 1;
                    }
                }
            }
        }

        if (table[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return table[amount];
    }
}
