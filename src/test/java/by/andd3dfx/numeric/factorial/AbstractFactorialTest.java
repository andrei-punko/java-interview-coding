package by.andd3dfx.numeric.factorial;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public abstract class AbstractFactorialTest {

    protected IFactorial instance;

    @Before
    public void setUp() throws Exception {
        instance = buildInstance();
    }

    protected abstract IFactorial buildInstance();

    @Test
    public void calc() {
        assertThat(instance.calc(0)).as("0!=1").isEqualTo(1L);
        assertThat(instance.calc(1)).as("1!=1").isEqualTo(1L);
        assertThat(instance.calc(2)).as("2!=2").isEqualTo(2L);
        assertThat(instance.calc(3)).as("3!=6").isEqualTo(6L);
        assertThat(instance.calc(4)).as("4!=24").isEqualTo(24L);
        assertThat(instance.calc(8)).as("8!=40320").isEqualTo(40320L);
    }

    @Test
    public void calcForNegative() {
        var ex = assertThrows(IllegalArgumentException.class, () -> instance.calc(-1));

        assertThat(ex.getMessage()).isEqualTo("n should be greater than 0");
    }
}
