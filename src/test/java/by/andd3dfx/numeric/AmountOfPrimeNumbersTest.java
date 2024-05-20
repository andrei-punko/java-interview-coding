package by.andd3dfx.numeric;

import org.junit.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountOfPrimeNumbersTest {

    @Test
    public void testDetermine_usingPrimeDividersOfNumberSolution() {
        check(AmountOfPrimeNumbers::determine_usingPrimeDividersOfNumberSolution);
    }

    @Test
    public void testDetermine_usingCustomIsPrimeWithEarlyReturn() {
        check(AmountOfPrimeNumbers::determine_usingCustomIsPrimeWithEarlyReturn);
    }

    @Test
    public void testDetermine_usingEratosthenesSieve() {
        check(AmountOfPrimeNumbers::determine_usingEratosthenesSieve);
    }

    @Test
    public void testDetermine_usingEratosthenesSieveWithBitSet() {
        check(AmountOfPrimeNumbers::determine_usingEratosthenesSieveWithBitSet);
    }

    private void check(Function<Integer, Integer> function) {
        assertThat(function.apply(2)).isEqualTo(0);
        assertThat(function.apply(3)).isEqualTo(1);
        assertThat(function.apply(4)).isEqualTo(2);
        assertThat(function.apply(5)).isEqualTo(2);
        assertThat(function.apply(6)).isEqualTo(3);
        assertThat(function.apply(7)).isEqualTo(3);
        assertThat(function.apply(8)).isEqualTo(4);
        assertThat(function.apply(10)).isEqualTo(4);
        assertThat(function.apply(11)).isEqualTo(4);
        assertThat(function.apply(12)).isEqualTo(5);
        assertThat(function.apply(15)).isEqualTo(6);
    }
}
