package by.andd3dfx.multithreading;

import org.junit.Test;

public class HelloRunnableTest {

    @Test
    public void run() throws Exception {
        Thread thread = new Thread(new HelloRunnable());
        thread.start();
    }
}
