package by.andd3dfx.multithreading.lock;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class ReentrantLockWrapper {

    private final Lock lock;

    @SneakyThrows
    public void outer() {
        lock.lock();
        inner();
        lock.unlock();
    }

    @SneakyThrows
    public synchronized void inner() {
        lock.lock();
        System.out.println("Do something special...");
        Thread.sleep(50);
        lock.unlock();
    }
}
