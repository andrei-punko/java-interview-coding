package by.andd3dfx.multithreading;

import by.andd3dfx.multithreading.AddMultithreading.SystemA;
import by.andd3dfx.multithreading.AddMultithreading.SystemB;
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
                new SystemA("One"),
                new SystemB("Two")
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
                new SystemA("One"),
                new SystemB("Two")
        );

        var future = CompletableFuture.supplyAsync(() -> aggregator.doRequest());

        await().atMost(1_100, TimeUnit.MILLISECONDS)
                .until(() -> future.isDone());
        assertThat(future.get()).isEqualTo("OneTwo");
    }

    @Test
    public void checkMultithreadingPresenceFor10Requests() throws ExecutionException, InterruptedException {
        var aSystems = new SystemA[5];
        var bSystems = new SystemB[5];
        for (int i = 0; i < aSystems.length; i++) {
            aSystems[i] = new SystemA(String.valueOf(i));
        }
        for (int i = 0; i < bSystems.length; i++) {
            bSystems[i] = new SystemB(String.valueOf(i * i));
        }

        var aggregator = new AddMultithreading.Aggregator(aSystems, bSystems);

        var future = CompletableFuture.supplyAsync(() -> aggregator.doRequest10());

        await().atMost(1_500, TimeUnit.MILLISECONDS)
                .until(() -> future.isDone());
        assertThat(future.get()).isEqualTo("01234014916");
    }
}
