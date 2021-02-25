package by.andd3dfx.multithreading.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Examples from this article: https://www.baeldung.com/java-completablefuture
 */
public class FutureMain {

    /**
     * CompletableFuture usage example
     */
    public Future<String> calculateViaSubmitToExecutor() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello Async");
            return null;
        });

        return completableFuture;
    }

    /**
     * CompletableFuture usage example when computation result already known
     */
    public Future<String> calculateWhenResultKnown() {
        return CompletableFuture.completedFuture("Hello Known");
    }

    /**
     * CompletableFuture compact usage example using Runnable (when no result required)
     */
    public Future<Void> calculateWithPassingRunnableIntoFuture() {
        return CompletableFuture.runAsync(() -> {
            System.out.println("Bla-Bla ...");
        });
    }

    /**
     * CompletableFuture compact usage example using Supplier
     */
    public Future<String> calculateWithPassingSupplierIntoFuture() {
        return CompletableFuture.supplyAsync(() -> "Hello Supplier");
    }

    /**
     * Processing results of async computations
     * <p>
     * thenApply() - we can use this method to work with a result of the previous call
     */
    public Future<String> processingResultsOfAsyncComputations() {
        CompletableFuture<String> completableFuture
            = CompletableFuture.supplyAsync(() -> "Hello Async");

        CompletableFuture<String> future = completableFuture
            .thenApply(s -> s + " Additional action");

        // This (thenApplyAsync method) allows us to parallelize our computation even more
        // and use system resources more efficiently
        CompletableFuture<String> future2 = future
            .thenApplyAsync(s -> s + " Additional action 2");

        return future2;
    }

    /**
     * Processing results of async computations when no result required
     */
    public CompletableFuture<Void> processingResultsOfAsyncComputationsWithoutResult() {
        CompletableFuture<String> completableFuture
            = CompletableFuture.supplyAsync(() -> "Hello Async");

        CompletableFuture<Void> future = completableFuture
            .thenAccept(s -> System.out.println(s + " Additional action"));

        return future;
    }

    /**
     * Processing results of async computations when we neither need the value of the computation,
     * <p>
     * nor want to return some value at the end of the chain
     */
    public CompletableFuture<Void> processingResultsOfAsyncComputationsWithoutResultAndReturn() {
        CompletableFuture<String> completableFuture
            = CompletableFuture.supplyAsync(() -> "Hello Async");

        CompletableFuture<Void> future = completableFuture
            .thenRun(() -> System.out.println("Job done!"));

        return future;
    }

    /**
     * Combine futures sequentially using thenCompose
     * <p>
     * thenCompose() uses the previous stage as the argument.
     * <p>
     * So if the idea is to chain CompletableFuture methods then it’s better to use thenCompose()
     */
    public CompletableFuture<String> combineFuturesSequentially() {
        return CompletableFuture
            .supplyAsync(() -> "Hello")
            .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World Sequentially"));
    }

    /**
     * Combine futures in parallel using thenCombine
     */
    public CompletableFuture<String> combineFuturesInParallel() {
        return CompletableFuture
            .supplyAsync(() -> "Hello")
            .thenCombine(CompletableFuture.supplyAsync(() -> " World In Parallel"), (s1, s2) -> s1 + s2);
    }

    /**
     * Combine futures in parallel using thenAcceptBoth when don't need to pass any resulting value into Future chain
     */
    public CompletableFuture<Void> combineFuturesInParallelWhenResultNotNeeded() {
        return CompletableFuture
            .supplyAsync(() -> "Hello")
            .thenAcceptBoth(
                CompletableFuture.supplyAsync(() -> " World In Parallel"),
                (s1, s2) -> System.out.println(s1 + s2)
            );
    }

    /**
     * Run multiple futures in parallel
     */
    public CompletableFuture<Void> runFuturesInParallelWithoutResult() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture
            = CompletableFuture.allOf(future1, future2, future3);

        return combinedFuture;
    }

    /**
     * Run multiple futures in parallel
     */
    public String runFuturesInParallelWithResult() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        return Stream.of(future1, future2, future3)
            .map(CompletableFuture::join)
            .collect(Collectors.joining(" "));
    }

    /**
     * Handle errors thrown in future
     */
    public CompletableFuture<String> handleErrorsInFuture(String name) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return String.format("Hello, %s!", name);
        }).handle((resultString, exceptionThrown) -> determineString(resultString));

        return future;
    }

    private String determineString(String resultString) {
        return resultString != null ? resultString : "Hello, Stranger!";
    }

    /**
     * Complete future exceptionally
     */
    public CompletableFuture<String> completeExceptionally() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.completeExceptionally(new RuntimeException("Calculation failed!"));

        return completableFuture;
    }
}
