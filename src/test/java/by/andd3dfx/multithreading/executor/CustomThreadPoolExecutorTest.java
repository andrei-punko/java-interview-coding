package by.andd3dfx.multithreading.executor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomThreadPoolExecutorTest {

    private CustomThreadPoolExecutor executor;

    @Before
    public void setUp() throws Exception {
        executor = new CustomThreadPoolExecutor(2);
    }

    @Test
    public void testSubmitNShutdown() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            var submitResult = executor.submit(new TestTask(i));
            assertTrue(submitResult);
        }

        Thread.sleep(100);
        executor.shutdown();

        for (int i = 1; i <= 3; i++) {
            var submitResult = executor.submit(new TestTask(i));
            assertFalse(submitResult);
        }

        Thread.sleep(500);
    }
}
