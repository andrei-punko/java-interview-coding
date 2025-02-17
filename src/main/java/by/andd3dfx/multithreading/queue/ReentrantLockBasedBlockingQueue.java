package by.andd3dfx.multithreading.queue;

import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 * Implementation of blocking queue based on locks.
 *
 * With help of <a href="https://www.baeldung.com/java-concurrent-locks">article</a>
 * </pre>
 */
@RequiredArgsConstructor
public class ReentrantLockBasedBlockingQueue<T> implements CustomBlockingQueue<T> {

    private final int size;
    private Queue<T> queue = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition queueEmptyCondition = lock.newCondition();
    private Condition queueFullCondition = lock.newCondition();

    @Override
    public void enqueue(T item) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == size) {
                queueFullCondition.await();
            }
            queue.offer(item);
            queueEmptyCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public T dequeue() throws InterruptedException {
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
