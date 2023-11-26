package by.andd3dfx.numeric.factorial;

/**
 * Down-top approach
 */
public class FactorialUsingLoop implements IFactorial {

    @Override
    public long calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be greater than 0");
        }

        if (n == 0) {
            return 1;
        }

        long result = 1;
        for (var i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
