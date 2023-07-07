package by.andd3dfx.multithreading;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class AddMultithreadingTest {

    @Test
    public void checkMultithreadingAbsence() throws ExecutionException, InterruptedException {
        var aggregator = new AddMultithreading.Aggregator(
                new AddMultithreading.SystemA("One"),
                new AddMultithreading.SystemB("Two")
        );

        var future = CompletableFuture.supplyAsync(() -> aggregator.doRequestOld());

        await().atLeast(2, TimeUnit.SECONDS)
                .atMost(3, TimeUnit.SECONDS)
                .until(() -> future.isDone());
        assertThat(future.get()).isEqualTo("OneTwo");
    }

    @Test
    public void checkMultithreadingPresence() throws ExecutionException, InterruptedException {
        var aggregator = new AddMultithreading.Aggregator(
                new AddMultithreading.SystemA("One"),
                new AddMultithreading.SystemB("Two")
        );

        var future = CompletableFuture.supplyAsync(() -> aggregator.doRequest());

        await().atMost(1_100, TimeUnit.MILLISECONDS)
                .until(() -> future.isDone());
        assertThat(future.get()).isEqualTo("OneTwo");
    }
}
