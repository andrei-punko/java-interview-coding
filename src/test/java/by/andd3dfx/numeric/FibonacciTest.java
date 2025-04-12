package by.andd3dfx.numeric;

import org.junit.Test;

import java.util.function.Function;

import static by.andd3dfx.numeric.Fibonacci.calculateDownTop;
import static by.andd3dfx.numeric.Fibonacci.calculateTopDown;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class FibonacciTest {

    @Test
    public void testCalculateTopDown() {
        assertThat(calculateTopDown(2)).isEqualTo(1);
        assertThat(calculateTopDown(4)).isEqualTo(3);
        assertThat(calculateTopDown(1)).isEqualTo(1);
        assertThat(calculateTopDown(0)).isEqualTo(0);
        assertThat(calculateTopDown(8)).isEqualTo(21);
        assertThat(calculateTopDown(9)).isEqualTo(34);
        assertThat(calculateTopDown(3)).isEqualTo(2);
        assertThat(calculateTopDown(7)).isEqualTo(13);
        assertThat(calculateTopDown(10)).isEqualTo(55);
        assertThat(calculateTopDown(6)).isEqualTo(8);
        assertThat(calculateTopDown(5)).isEqualTo(5);
    }

    @Test
    public void testCalculateDownTop() {
        assertThat(calculateDownTop(2)).isEqualTo(1);
        assertThat(calculateDownTop(4)).isEqualTo(3);
        assertThat(calculateDownTop(1)).isEqualTo(1);
        assertThat(calculateDownTop(0)).isEqualTo(0);
        assertThat(calculateDownTop(8)).isEqualTo(21);
        assertThat(calculateDownTop(9)).isEqualTo(34);
        assertThat(calculateDownTop(3)).isEqualTo(2);
        assertThat(calculateDownTop(7)).isEqualTo(13);
        assertThat(calculateDownTop(10)).isEqualTo(55);
        assertThat(calculateDownTop(6)).isEqualTo(8);
        assertThat(calculateDownTop(5)).isEqualTo(5);
    }

    @Test
    public void calculateTopDownForWrongParam() {
        checkIsExceptionThrown(Fibonacci::calculateTopDown, -1);
        checkIsExceptionThrown(Fibonacci::calculateTopDown, -10);
    }

    @Test
    public void calculateDownTopForWrongParam() {
        checkIsExceptionThrown(Fibonacci::calculateDownTop, -1);
        checkIsExceptionThrown(Fibonacci::calculateDownTop, -10);
    }

    private void checkIsExceptionThrown(Function<Integer, Integer> function, int n) {
        try {
            function.apply(n);
            fail("Exception should be thrown");
        } catch (IllegalArgumentException iae) {
            assertThat(iae.getMessage()).isEqualTo("Number should be not less than 0!");
        }
    }
}
