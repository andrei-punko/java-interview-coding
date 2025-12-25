package by.andd3dfx.multithreading;

import org.junit.Test;

import static org.awaitility.Awaitility.await;
import static org.awaitility.Durations.ONE_HUNDRED_MILLISECONDS;
import static org.awaitility.Durations.ONE_SECOND;

public class FooBarNTimesTest {

    @Test
    public void checkLogs() {
        FooBarNTimes.FooBar fooBar = new FooBarNTimes.FooBar(4);

        Thread thread1 = new Thread(() -> fooBar.foo());
        Thread thread2 = new Thread(() -> fooBar.bar());

        thread1.start();
        thread2.start();

        await()
            .atMost(ONE_SECOND)
            .pollInterval(ONE_HUNDRED_MILLISECONDS)
            .until(() -> fooBar.getLogWriter().toString().matches("(foobar){4}"));
    }
}
