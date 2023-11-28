package by.andd3dfx.numeric.factorial;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class FactorialUsingForkJoinPoolTest extends AbstractFactorialTest {

    @Override
    protected IFactorial buildInstance() {
        return new FactorialUsingForkJoinPool();
    }

    @Test
    @Override
    public void calcForNegative() {
        var ex = assertThrows(ExecutionException.class, () -> instance.calc(-1));

        assertThat(ex.getCause().getMessage())
                .isEqualTo("java.lang.IllegalArgumentException: n should be greater than 0");
    }
}
