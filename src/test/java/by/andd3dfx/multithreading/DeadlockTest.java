package by.andd3dfx.multithreading;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeadlockTest {

    @Test
    public void testDeadlock() throws InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            new Deadlock().makeDeadlock();
            return null;
        });

        new Thread(() -> {
            try {
                future.get();
                System.out.printf("Completed");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).start();

        // Wait 1 sec
        Thread.sleep(1000);

        assertThat("Should not be completed after 1 sec wait", future.isDone(), is(false));
    }
}
