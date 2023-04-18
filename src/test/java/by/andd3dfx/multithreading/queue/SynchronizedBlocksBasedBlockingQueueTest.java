package by.andd3dfx.multithreading.queue;

public class SynchronizedBlocksBasedBlockingQueueTest extends AbstractBlockingQueueTest {

    @Override
    protected CustomBlockingQueue buildQueue(int size) {
        return new SynchronizedBlocksBasedBlockingQueue(size);
    }
}
