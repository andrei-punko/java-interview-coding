package by.andd3dfx.multithreading.executor;

import org.junit.Before;
import org.junit.Test;

public class ThreadPoolExecutorTest {

    private ThreadPoolExecutor executor;

    @Before
    public void setUp() throws Exception {
        executor = new ThreadPoolExecutor(2);
    }

    @Test
    public void testSubmitNShutdown() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            executor.submit(new TestTask(i));
        }

        Thread.sleep(100);
        executor.shutdown();

        for (int i = 1; i <= 5; i++) {
            executor.submit(new TestTask(i));
        }

        Thread.sleep(500);
    }
}
