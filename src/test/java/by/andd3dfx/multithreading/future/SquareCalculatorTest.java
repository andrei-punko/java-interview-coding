package by.andd3dfx.multithreading.future;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

public class SquareCalculatorTest {

    @Test
    public void test() throws InterruptedException, ExecutionException {
        SquareCalculator squareCalculator = new SquareCalculator();

        Future<Integer> future1 = squareCalculator.calculate(10);
        Future<Integer> future2 = squareCalculator.calculate(100);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(
                String.format(
                    "future1 is %s and future2 is %s",
                    future1.isDone() ? "done" : "not done",
                    future2.isDone() ? "done" : "not done"
                )
            );
            Thread.sleep(300);
        }

        Integer result1 = future1.get();
        Integer result2 = future2.get();
        System.out.println(result1 + " and " + result2);

        assertThat(result1).isEqualTo(100);
        assertThat(result2).isEqualTo(10000);

        squareCalculator.shutdown();
    }
}