package by.andd3dfx.numeric;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FactorialTest {

    @Test(expected = IllegalArgumentException.class)
    public void calculateForNegativeParam() {
        Factorial.calculate(-1);
    }

    @Test
    public void calculate() {
        assertThat("0!=1", Factorial.calculate(0), is(1));
        assertThat("1!=1", Factorial.calculate(1), is(1));
        assertThat("2!=2", Factorial.calculate(2), is(2));
        assertThat("3!=6", Factorial.calculate(3), is(6));
        assertThat("8!=40320", Factorial.calculate(8), is(40320));
    }
}
