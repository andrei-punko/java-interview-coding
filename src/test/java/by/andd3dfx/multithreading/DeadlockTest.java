package by.andd3dfx.multithreading;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertFalse;

public class DeadlockTest {

    @Ignore("Fail of Github CI build")
    @Test
    public void makeDeadlock() throws InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            new Deadlock().makeDeadlock();
            return null;
        });

        new Thread(() -> {
            try {
                future.get();
                System.out.println("Future completed!");
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).start();

        // Wait 1 sec
        Thread.sleep(1000);

        assertFalse("Should not be completed after 1 sec wait", future.isDone());
    }
}
