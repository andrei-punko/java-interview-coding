package by.andd3dfx.multithreading.threadpool;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractBlockingQueueTest {

    private CustomBlockingQueue<String> queue;
    private Random random = new Random();

    @Before
    public void setUp() {
        queue = buildQueue(10);
    }

    protected abstract CustomBlockingQueue<String> buildQueue(int size);

    @Test
    public void test() throws InterruptedException {
        Thread enqueueThread1 = new Thread(() -> {
            int counter = 1;
            while (true) {
                try {
                    queue.enqueue("A" + counter);
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
            }
        });
        Thread enqueueThread2 = new Thread(() -> {
            int counter = 1;
            while (true) {
                try {
                    queue.enqueue("B" + counter);
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
            }
        });

        Thread dequeueThread = new Thread(() -> {
            while (true) {
                try {
                    var number = queue.dequeue();

                    // System.out.print(number + " ");

                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        enqueueThread1.start();
        enqueueThread2.start();
        dequeueThread.start();
        Thread.sleep(100);
    }
}
