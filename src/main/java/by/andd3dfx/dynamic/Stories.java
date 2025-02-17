package by.andd3dfx.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * An industrial building is being divided up and converted into apartments. A large apartment takes up two stories
 * of the building, and a small apartment takes up one story.
 * Write a function that, given the number of stories in the building, calculates the number of different apartment
 * combinations.
 * For example, if the building is three stories high it can accommodate three different apartment combinations:
 * small-small-small, small-large and large-small.
 *
 * --- Solution notes ---
 * When we wrote set of results for several input values - we discover that they are equal to fibonacci numbers:
 * 1 -> 1
 * 2 -> 2: 1+1, 2
 * 3 -> 3: 1+1+1, 2+1, 1+2
 * 4 -> 5: 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2
 * 5 -> 8: 1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1, 1+2+2, 2+1+2, 2+2+1
 * ...
 * so decided to use this fibonacci value as function result.
 * </pre>
 *
 * @see <a href="https://youtu.be/W3RefFMsnRo">Video solution</a>
 */
public class Stories {

    private static final Map<Integer, Integer> cache = new HashMap<>();

    public static int combinations(int numberOfStories) {
        return fibonacci(numberOfStories + 1);
    }

    static int fibonacci(int n) {
        Integer value = cache.get(n);
        if (value != null) {
            return value;
        }

        if (n <= 1) {
            return n;
        }

        int result = fibonacci(n - 1) + fibonacci(n - 2);
        cache.put(n, result);
        return result;
    }
}
