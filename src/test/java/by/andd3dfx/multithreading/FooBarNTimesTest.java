package by.andd3dfx.multithreading;

import org.awaitility.Durations;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class FooBarNTimesTest {

    @Test
    public void checkLogs() {
        FooBarNTimes.FooBar fooBar = new FooBarNTimes.FooBar(4);

        Thread thread1 = new Thread(() -> fooBar.foo());
        Thread thread2 = new Thread(() -> fooBar.bar());

        thread1.start();
        thread2.start();

        await()
                .atMost(Durations.ONE_SECOND)
                .pollInterval(50, TimeUnit.MILLISECONDS)
                .until(() -> fooBar.getLogWriter().toString().matches("(foobar){4}"));
    }
}
