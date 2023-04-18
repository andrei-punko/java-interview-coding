package by.andd3dfx.multithreading.queue;

public class ReentrantLockBasedBlockingQueueTest extends AbstractBlockingQueueTest {

    @Override
    protected CustomBlockingQueue buildQueue(int size) {
        return new ReentrantLockBasedBlockingQueue(size);
    }
}
