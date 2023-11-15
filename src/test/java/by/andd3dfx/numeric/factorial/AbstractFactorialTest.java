package by.andd3dfx.numeric.factorial;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

public abstract class AbstractFactorialTest {

    private IFactorial instance;

    @Before
    public void setUp() throws Exception {
        instance = buildInstance();
    }

    protected abstract IFactorial buildInstance();

    @Test
    public void calc() {
        assertThat("0!=1", instance.calc(0), is(1L));
        assertThat("1!=1", instance.calc(1), is(1L));
        assertThat("2!=2", instance.calc(2), is(2L));
        assertThat("3!=6", instance.calc(3), is(6L));
        assertThat("4!=24", instance.calc(4), is(24L));
        assertThat("8!=40320", instance.calc(8), is(40320L));
    }

    @Test
    public void calcForNegative() {
        var ex = assertThrows(IllegalArgumentException.class, () -> instance.calc(-1));

        assertThat(ex.getMessage(), is("n should be greater than 0"));
    }
}
