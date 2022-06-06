package by.andd3dfx.multithreading.forkjoin;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

import static java.lang.Thread.sleep;

public class CustomRecursiveActionTest {

    private ForkJoinPool forkJoinPool;

    @Before
    public void setup() {
        forkJoinPool = ForkJoinPool.commonPool();
    }

    @Test
    public void testCustomRecursiveActionViaSubmit() throws InterruptedException {
        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("Some very long and boring string");

        forkJoinPool.submit(customRecursiveAction);

        while (!customRecursiveAction.isDone()) {
            sleep(500);
        }
    }

    @Test
    public void testCustomRecursiveActionViaExecute() throws InterruptedException {
        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("Some very long and boring string");

        forkJoinPool.execute(customRecursiveAction);

        while (!customRecursiveAction.isDone()) {
            sleep(500);
        }
    }

    @Test
    public void testCustomRecursiveActionViaInvoke() throws InterruptedException {
        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("Some very long and boring string");

        forkJoinPool.invoke(customRecursiveAction);

        while (!customRecursiveAction.isDone()) {
            sleep(500);
        }
    }

    @Test
    public void testCustomRecursiveActionViaForkNJoin() throws InterruptedException {
        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("Some very long and boring string");

        customRecursiveAction.fork();
        customRecursiveAction.join();

        while (!customRecursiveAction.isDone()) {
            sleep(500);
        }
    }
}
