package by.andd3dfx.multithreading.threadpool;

import java.util.LinkedList;
import java.util.Queue;

/*
    1.BlockingQueue simulates the blocking queue implementation.
    2.We have used LinkedList as underlying data structure.
    3.BlockingQueue contains couple of synchronized methods
        - enqueue : It enqueue (push) Task to the queue
        - dequeue : This method takes (pop) the task from the queue.

    This queue implementation based on synchronized methods
 */
public class SynchronizedBlocksBasedBlockingQueue<Type> implements CustomBlockingQueue<Type> {

    private final int MAX_QUEUE_SIZE;
    private Queue<Type> queue = new LinkedList<>();

    public SynchronizedBlocksBasedBlockingQueue(int size) {
        this.MAX_QUEUE_SIZE = size;
    }

    @Override
    public synchronized void enqueue(Type task) throws InterruptedException {
        while (queue.size() == MAX_QUEUE_SIZE) {
            wait();
        }
        if (queue.isEmpty()) {
            notifyAll();
        }
        queue.offer(task);
    }

    @Override
    public synchronized Type dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        if (queue.size() == MAX_QUEUE_SIZE) {
            notifyAll();
        }
        return queue.poll();
    }
}
