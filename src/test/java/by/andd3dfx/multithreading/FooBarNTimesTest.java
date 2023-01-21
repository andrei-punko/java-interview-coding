package by.andd3dfx.multithreading;

import org.junit.Test;

public class FooBarNTimesTest {

    @Test
    public void test() throws InterruptedException {
        FooBarNTimes.FooBar fooBar = new FooBarNTimes.FooBar(4);

        Thread thread1 = new Thread(() -> fooBar.foo());
        Thread thread2 = new Thread(() -> fooBar.bar());

        thread1.start();
        thread2.start();

        Thread.sleep(500);
    }
}
