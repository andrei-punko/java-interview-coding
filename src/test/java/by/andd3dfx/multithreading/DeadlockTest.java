package by.andd3dfx.multithreading;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertFalse;

public class DeadlockTest {

    @Test
    public void makeDeadlock() throws InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            new Deadlock().makeDeadlock();
            return null;
        });

        new Thread(() -> completeFuture(future)).start();

        // Wait 1 sec
        Thread.sleep(1000);

        assertFalse("Should not be completed after 1 sec wait", future.isDone());
    }

    @SneakyThrows
    private void completeFuture(CompletableFuture<Void> future) {
        future.get();
        System.out.println("Future completed!");
    }
}
