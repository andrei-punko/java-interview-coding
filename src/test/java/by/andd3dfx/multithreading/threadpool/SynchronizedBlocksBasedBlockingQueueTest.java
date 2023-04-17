package by.andd3dfx.multithreading.threadpool;

public class SynchronizedBlocksBasedBlockingQueueTest extends AbstractBlockingQueueTest {

    @Override
    protected CustomBlockingQueue buildQueue(int size) {
        return new SynchronizedBlocksBasedBlockingQueue(size);
    }
}
