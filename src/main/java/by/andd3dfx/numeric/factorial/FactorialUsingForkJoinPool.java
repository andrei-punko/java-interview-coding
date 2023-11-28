package by.andd3dfx.numeric.factorial;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FactorialUsingForkJoinPool implements IFactorial {

    private static final ForkJoinPool forkJoinPool = new ForkJoinPool();

    @SneakyThrows
    @Override
    public long calc(int n) {
        var task = new FactorialRecursiveTask(n);
        forkJoinPool.execute(task);

        return task.get();
    }

    /**
     * Based on article: https://www.baeldung.com/java-future#overview-of-forkjointask
     */
    @AllArgsConstructor
    public class FactorialRecursiveTask extends RecursiveTask<Integer> {
        private Integer n;

        @Override
        protected Integer compute() {
            if (n < 0) throw new IllegalArgumentException("n should be greater than 0");
            if (n == 0) return 1;

            var task = new FactorialRecursiveTask(n - 1);
            task.fork();
            return n * task.join();
        }
    }
}
