package by.andd3dfx.multithreading;

public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.printf("Hello, I'm runnable");
    }
}
