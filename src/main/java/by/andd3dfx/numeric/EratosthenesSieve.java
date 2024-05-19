package by.andd3dfx.numeric;

import java.util.Arrays;

/**
 * Find amount of prime numbers which less than definite number N.
 * <p>
 * See <a href="https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes">Sieve of Eratosthenes</a>
 */
public class EratosthenesSieve {

    public static int apply(int n) {
        var isPrime = new boolean[n];
        Arrays.fill(isPrime, 2, n, true);

        for (var i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (var j = i; j * i < n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        int result = 0;
        for (var item : isPrime) {
            if (item) {
                result++;
            }
        }
        return result;
    }
}
