package by.andd3dfx.multithreading;

import java.io.StringWriter;
import org.junit.Test;

import static java.lang.Math.random;
import static java.lang.Thread.sleep;

public class CustomCacheTest {
    private final int COUNT = 100;
    private static final StringWriter writer = new StringWriter();

    @Test
    public void testCache() throws InterruptedException {
        CustomCache customCache = new CustomCache();
        for (int i = 0; i < COUNT; i++) {
            customCache.write(i, func(i));
        }

        Thread readingThread1 = new Thread(() -> {
            while (true) {
                delay();
                int index = (int) (COUNT * random());
                Object value = customCache.read(index);
                writer.write("Read thread 1, A[" + index + "] -> " + value);
            }
        });
        Thread readingThread2 = new Thread(() -> {
            while (true) {
                delay();
                int index = (int) (COUNT * random());
                Object value = customCache.read(index);
                writer.write("Read thread 2, A[" + index + "] -> " + value);
            }
        });
        Thread writingThread = new Thread(() -> {
            while (true) {
                delay();
                int index = (int) (COUNT * random());
                int value = func(index);
                customCache.write(index, value);
                writer.write("Write thread, A[" + index + "] <- " + value);
            }
        });

        readingThread1.start();
        readingThread2.start();
        writingThread.start();

        sleep(20);
    }

    private void delay() {
        try {
            sleep((long) (10 * random()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int func(int arg) {
        return arg * arg + 5;
    }
}
