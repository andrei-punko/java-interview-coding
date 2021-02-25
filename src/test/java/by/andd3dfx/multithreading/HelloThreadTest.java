package by.andd3dfx.multithreading;

import org.junit.Test;

public class HelloThreadTest {

    @Test
    public void run() throws Exception {
        HelloThread thread = new HelloThread();
        thread.start();
    }
}
