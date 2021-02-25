package by.andd3dfx.multithreading.threadpool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock-based implementation of queue.
 *
 * With help of https://www.baeldung.com/java-concurrent-locks
 */
public class ReentrantLockBasedBlockingQueue<Type> implements CustomBlockingQueue<Type> {

    private final int MAX_QUEUE_SIZE;
    private Queue<Type> queue = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition queueEmptyCondition = lock.newCondition();
    private Condition queueFullCondition = lock.newCondition();

    public ReentrantLockBasedBlockingQueue(int size) {
        this.MAX_QUEUE_SIZE = size;
    }

    @Override
    public void enqueue(Type item) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == MAX_QUEUE_SIZE) {
                queueFullCondition.await();
            }
            queue.offer(item);
            queueEmptyCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Type dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                queueEmptyCondition.await();
            }
            return queue.poll();
        } finally {
            queueFullCondition.signalAll();
            lock.unlock();
        }
    }
}
