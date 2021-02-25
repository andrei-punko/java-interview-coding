package by.andd3dfx.multithreading.threadpool;

public class SynchronizedBlocksBasedBlockingQueueTest extends AbstractBlockingQueueTest {

    @Override
    protected CustomBlockingQueue<Integer> buildQueue(int size) {
        return new SynchronizedBlocksBasedBlockingQueue(size);
    }
}
