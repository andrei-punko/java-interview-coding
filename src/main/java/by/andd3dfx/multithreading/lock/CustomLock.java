package by.andd3dfx.multithreading.lock;

/**
 * Custom lock with simple implementation but without reentrancy support
 * <p>
 * See https://jenkov.com/tutorials/java-concurrency/locks.html
 *
 * @see <a href="https://youtu.be/QdvsNhf5FI4">Video solution</a>
 */
public class CustomLock implements Lock {

    private boolean isLocked = false;

    @Override
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
        System.out.println("Locked...");
    }

    @Override
    public synchronized void unlock() {
        isLocked = false;
        System.out.println("Unlocked...");
        notify();
    }
}
