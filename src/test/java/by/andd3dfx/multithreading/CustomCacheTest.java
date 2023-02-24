package by.andd3dfx.multithreading;

import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Math.random;
import static java.lang.Thread.sleep;

public class CustomCacheTest {

    private final int ITEMS_COUNT = 4;
    private final int READING_THREADS_COUNT = 5;
    private Thread[] readingThreads;
    private Thread writingThread;

    private CustomCache customCache;

    @Before
    public void setUp() throws Exception {
        customCache = new CustomCache();
        for (int i = 0; i < ITEMS_COUNT; i++) {
            customCache.write(i, generateNewValue(i));
        }

        readingThreads = new Thread[READING_THREADS_COUNT];
        for (int i = 0; i < READING_THREADS_COUNT; i++) {
            final int effectivelyFinalI = i;
            readingThreads[effectivelyFinalI] = new Thread(() -> reading(effectivelyFinalI));
        }
        writingThread = new Thread(() -> writing());
    }

    @Test
    public void testCache() throws InterruptedException {
        for (Thread readingThread : readingThreads) {
            readingThread.start();
        }
        writingThread.start();

        sleep(100);
    }

    private void writing() {
        for (int i = 0; i < 10; i++) {
            delay();
            int index = (int) (ITEMS_COUNT * random());
            int value = generateNewValue(index);
            customCache.write(index, value);

            System.out.printf("Writing: A[%d]<-%d%n", index, value);
        }
    }

    private void reading(int threadNumber) {
        for (int i = 0; i < 10; i++) {
            delay();
            int index = (int) (ITEMS_COUNT * random());
            Object value = customCache.read(index);

            System.out.printf("Reading %d: A[%d]->%s%n", threadNumber, index, value);
        }
    }

    @SneakyThrows
    private void delay() {
        sleep((long) (10 * random()));
    }

    private int generateNewValue(int arg) {
        return (int) (10 * random());
    }
}
