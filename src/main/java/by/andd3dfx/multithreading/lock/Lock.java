package by.andd3dfx.multithreading.lock;

public interface Lock {

    void lock() throws InterruptedException;

    void unlock();
}
