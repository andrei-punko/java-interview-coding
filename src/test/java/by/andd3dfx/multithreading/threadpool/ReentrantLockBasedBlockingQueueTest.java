package by.andd3dfx.multithreading.threadpool;

public class ReentrantLockBasedBlockingQueueTest extends AbstractBlockingQueueTest {

    @Override
    protected CustomBlockingQueue buildQueue(int size) {
        return new ReentrantLockBasedBlockingQueue(size);
    }
}
