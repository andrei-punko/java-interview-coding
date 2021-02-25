package by.andd3dfx.multithreading.future;

import java.util.concurrent.RecursiveTask;

/**
 * Based on article: https://www.baeldung.com/java-future#overview-of-forkjointask
 */
public class FactorialSquareCalculator extends RecursiveTask<Integer> {
    // Used RecursiveTask (not RecursiveAction) because we need to get result of each part of computation

    private Integer n;

    public FactorialSquareCalculator(Integer n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n < 1) {
            throw new IllegalArgumentException("N should be greater than 0");
        }
        if (n == 1) {
            return 1;
        }

        FactorialSquareCalculator calculator = new FactorialSquareCalculator(n - 1);
        calculator.fork();
        return n * n + calculator.join();
    }
}
