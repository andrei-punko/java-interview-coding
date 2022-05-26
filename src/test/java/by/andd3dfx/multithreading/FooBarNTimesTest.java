package by.andd3dfx.multithreading;

import org.junit.Test;

public class FooBarNTimesTest {

    @Test
    public void test() throws InterruptedException {
        FooBarNTimes.FooBar fooBar = new FooBarNTimes.FooBar(5);

        Thread thread1 = new Thread(() -> {
            try {
                fooBar.foo();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                fooBar.bar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        Thread.sleep(500);
    }
}
