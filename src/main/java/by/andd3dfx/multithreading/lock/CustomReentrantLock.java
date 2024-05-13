package by.andd3dfx.multithreading.lock;

/**
 * Custom lock with reentrancy support
 * <p>
 * See https://jenkov.com/tutorials/java-concurrency/locks.html
 *
 * @see <a href="https://youtu.be/QdvsNhf5FI4">Video solution</a>
 */
public class CustomReentrantLock implements Lock {

    private boolean isLocked = false;
    private Thread lockedBy;
    private int lockedCount = 0;

    @Override
    public synchronized void lock() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while (isLocked && lockedBy != callingThread) {
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = callingThread;
        System.out.println("Locked...");
    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() == lockedBy) {
            lockedCount--;

            if (lockedCount == 0) {
                isLocked = false;
                System.out.println("Unlocked...");
                notify();
            }
        }
    }
}
