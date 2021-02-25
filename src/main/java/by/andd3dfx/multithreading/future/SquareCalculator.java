package by.andd3dfx.multithreading.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Based on article: https://www.baeldung.com/java-future
 */
public class SquareCalculator {

    private ExecutorService executor = Executors.newFixedThreadPool(2);

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}
