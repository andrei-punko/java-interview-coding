package by.andd3dfx.multithreading;

public class HelloThread extends Thread {
    @Override
    public void run() {
        System.out.printf("Hello, I'm thread");
    }
}
