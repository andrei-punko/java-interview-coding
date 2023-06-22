package by.andd3dfx.multithreading.lock;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class LockWrapper {

    private final Lock lock;

    @SneakyThrows
    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }
}
