package by.andd3dfx.numeric;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Find amount of prime numbers which less than definite number N.
 * <p>
 * See <a href="https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes">Sieve of Eratosthenes</a>
 */
public class AmountOfPrimeNumbers {

    public static int determine_usingPrimeDividersOfNumberSolution(int n) {
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                result++;
            }
        }
        return result;
    }

    private static boolean isPrime(int number) {
        return PrimeDividersOfNumber.determine(number).length == 1;
    }

    public static int determine_usingCustomIsPrimeWithEarlyReturn(int n) {
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimeEnhanced(i)) {
                result++;
            }
        }
        return result;
    }

    private static boolean isPrimeEnhanced(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int determine_usingEratosthenesSieve(int n) {
        var isPrime = new boolean[n];
        Arrays.fill(isPrime, 2, n, true);

        for (var i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (var j = 2; j * i < n; j++) {
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

    public static int determine_usingEratosthenesSieveWithBitSet(int n) {
        var isPrime = new BitSet(n);
        isPrime.set(2, n);

        for (var i = 2; i < n; i++) {
            if (isPrime.get(i)) {
                for (var j = 2; j * i < n; j++) {
                    isPrime.clear(i * j);
                }
            }
        }

        return isPrime.cardinality();
    }
}
