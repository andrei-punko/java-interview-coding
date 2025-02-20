package by.andd3dfx.numeric;

import by.andd3dfx.dynamic.ChangeWithMinNumberOfCoins;

/**
 * See <a href="https://en.wikipedia.org/wiki/Coin_problem">article</a> in wiki
 * <p>
 * Find the largest monetary amount that cannot be obtained using only coins of specified denominations.
 */
public class FrobeniusCoinProblem {

    public static int find(int[] nominals) {
        var capAmount = determineStartingValueEnhanced(nominals);
        for (var amount = capAmount; amount >= 1; amount--) {
            if (ChangeWithMinNumberOfCoins.determine_usingMemoization(nominals, amount) == -1) {
                return amount;
            }
        }
        return 1;
    }

    /**
     * Method wasn't deleted for demo purposes
     */
    private static int determineStartingValuePrimitive(int[] nominals) {
        var result = 1;
        for (int nominal : nominals) {
            result *= nominal;
        }
        System.out.println(result);
        return result;
    }

    private static int determineStartingValueEnhanced(int[] nominals) {
        return LeastCommonMultiple.find(nominals);
    }
}
