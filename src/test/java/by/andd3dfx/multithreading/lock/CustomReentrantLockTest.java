package by.andd3dfx.multithreading.lock;

import org.awaitility.Durations;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class CustomReentrantLockTest {

    private Lock lock;

    @Before
    public void setUp() throws Exception {
        lock = new CustomReentrantLock();
    }

    @Test
    public void testLockConcurrency() throws InterruptedException {
        var lockWrapper = new LockWrapper(lock);

        AtomicInteger counter1 = new AtomicInteger();
        var thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                lockWrapper.lock();
                counter1.getAndIncrement();
            }
        });

        AtomicInteger counter2 = new AtomicInteger();
        var thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                lockWrapper.lock();
                counter2.getAndIncrement();
            }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(200);

        assertThat(counter1.get()).isEqualTo(5);
        assertThat(counter2.get()).isEqualTo(0);
    }

    @Test
    public void testLockReentrancy() {
        var future = CompletableFuture.runAsync(
                () -> new ReentrantLockWrapper(lock).outer()
        );

        await().atMost(Durations.ONE_SECOND)
                .pollInterval(50, TimeUnit.MILLISECONDS)
                .until(() -> future.isDone());
    }
}
