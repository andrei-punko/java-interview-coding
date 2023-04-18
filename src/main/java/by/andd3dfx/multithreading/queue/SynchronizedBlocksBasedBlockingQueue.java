package by.andd3dfx.multithreading.queue;

import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of blocking queue based on synchronized methods.
 */
@RequiredArgsConstructor
public class SynchronizedBlocksBasedBlockingQueue<T> implements CustomBlockingQueue<T> {

    private final int size;
    private Queue<T> queue = new LinkedList<>();

    @Override
    public synchronized void enqueue(T task) throws InterruptedException {
        while (queue.size() == size) {
            wait();
        }
        if (queue.isEmpty()) {
            notifyAll();
        }
        queue.offer(task);
    }

    @Override
    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        if (queue.size() == size) {
            notifyAll();
        }
        return queue.poll();
    }
}
