package by.andd3dfx.multithreading.future;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import org.junit.Test;

public class FactorialSquareCalculatorTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FactorialSquareCalculator calculator = new FactorialSquareCalculator(10);
        forkJoinPool.execute(calculator);

        assertThat(calculator.get(), is(385));
    }
}
