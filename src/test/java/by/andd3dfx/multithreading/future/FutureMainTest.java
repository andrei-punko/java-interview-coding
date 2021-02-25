package by.andd3dfx.multithreading.future;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.Before;
import org.junit.Test;

public class FutureMainTest {

    private FutureMain futureMain;

    @Before
    public void setup() {
        futureMain = new FutureMain();
    }

    @Test
    public void calculateAsync() throws ExecutionException, InterruptedException {
        Future<String> future = futureMain.calculateViaSubmitToExecutor();

        assertEquals("Hello Async", future.get());
    }

    @Test
    public void calculateWhenResultKnown() throws ExecutionException, InterruptedException {
        Future<String> future = futureMain.calculateWhenResultKnown();

        assertEquals("Hello Known", future.get());
    }

    @Test
    public void testCalculateWithRunnable() throws ExecutionException, InterruptedException {
        Future<Void> future = futureMain.calculateWithPassingRunnableIntoFuture();

        future.get();
    }

    @Test
    public void testCalculateWithSupplier() throws ExecutionException, InterruptedException {
        Future<String> future = futureMain.calculateWithPassingSupplierIntoFuture();

        assertEquals("Hello Supplier", future.get());
    }

    @Test
    public void testProcessingResultsOfAsyncComputations() throws ExecutionException, InterruptedException {
        Future<String> future = futureMain.processingResultsOfAsyncComputations();

        assertEquals("Hello Async Additional action Additional action 2", future.get());
    }

    @Test
    public void testProcessingResultsOfAsyncComputationsWithoutResult() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = futureMain.processingResultsOfAsyncComputationsWithoutResult();

        future.get();
    }

    @Test
    public void testProcessingResultsOfAsyncComputationsWithoutResult2() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = futureMain.processingResultsOfAsyncComputationsWithoutResultAndReturn();

        future.get();
    }

    @Test
    public void combineFuturesSequentially() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = futureMain.combineFuturesSequentially();

        assertEquals("Hello World Sequentially", future.get());
    }

    @Test
    public void combineFuturesInParallel() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = futureMain.combineFuturesInParallel();

        assertEquals("Hello World In Parallel", future.get());
    }

    @Test
    public void combineFuturesInParallelWhenResultNotNeeded() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = futureMain.combineFuturesInParallelWhenResultNotNeeded();

        future.get();
    }

    @Test
    public void runFuturesInParallelWithoutResult() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = futureMain.runFuturesInParallelWithoutResult();

        future.get();
    }

    @Test
    public void runFuturesInParallelWithResult() throws ExecutionException, InterruptedException {
        String result = futureMain.runFuturesInParallelWithResult();

        assertEquals("Hello Beautiful World", result);
    }

    @Test
    public void handleErrorsInFuture() throws ExecutionException, InterruptedException {
        assertEquals("Hello, Stranger!", futureMain.handleErrorsInFuture(null).get());
        assertEquals("Hello, Ivan!", futureMain.handleErrorsInFuture("Ivan").get());
    }

    @Test
    public void completeExceptionally() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = futureMain.completeExceptionally();

        try {
            future.get();
            fail("Exception should be thrown");
        } catch (ExecutionException re) {
            Throwable cause = re.getCause();
            assertEquals(RuntimeException.class, cause.getClass());
            assertEquals("Calculation failed!", cause.getMessage());
        }
    }
}
