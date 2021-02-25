package by.andd3dfx.java8.interfacebydefault;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FormulaTest {
    private Formula formula;

    @Before
    public void setup() {
        formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
    }

    @Test
    public void calculate() throws Exception {
        assertThat("Square root of argument expected", formula.calculate(1), is(10.0));
    }

    @Test
    public void sqrt() throws Exception {
        assertThat("Square root of 16 expected", formula.sqrt(16), is(4.0));
    }
}
