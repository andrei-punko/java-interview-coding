package by.andd3dfx.multithreading.future;

import lombok.AllArgsConstructor;

import java.util.concurrent.RecursiveTask;

/**
 * Based on <a href="https://www.baeldung.com/java-future#overview-of-forkjointask">article</a>
 */
@AllArgsConstructor
public class FactorialSquareCalculator extends RecursiveTask<Integer> {
    private Integer n;

    @Override
    protected Integer compute() {
        if (n < 1) {
            throw new IllegalArgumentException("N should be greater than 0");
        }
        if (n == 1) {
            return 1;
        }

        var calculator = new FactorialSquareCalculator(n - 1);
        calculator.fork();
        return n * n + calculator.join();
    }
}
