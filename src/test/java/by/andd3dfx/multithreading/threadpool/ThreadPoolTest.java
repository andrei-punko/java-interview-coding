package by.andd3dfx.multithreading.threadpool;

import org.junit.Test;

import static java.lang.Thread.sleep;

public class ThreadPoolTest {

    @Test
    public void testThreadPool() throws InterruptedException {
        // Create queue with size 3
        ThreadPool threadPool = new ThreadPool(3, 2);
        threadPool.start();

        // Created 15 Tasks and submit to pool
        for (int taskNumber = 1; taskNumber <= 5; taskNumber++) {
            TestTask task = new TestTask(taskNumber);
            threadPool.submitTask(task);
        }

        sleep(100);
        threadPool.shutdown();

        for (int taskNumber = 1; taskNumber <= 5; taskNumber++) {
            TestTask task = new TestTask(taskNumber);
            threadPool.submitTask(task);
        }

        sleep(1000);
    }
}
