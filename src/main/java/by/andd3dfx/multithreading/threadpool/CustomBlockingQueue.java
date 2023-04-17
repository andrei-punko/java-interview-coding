package by.andd3dfx.multithreading.threadpool;

/**
 * <pre>
 * BlockingQueue contains methods:
 * - enqueue: push task to the queue
 * - dequeue: takes/pop task from the queue.
 * </pre>
 */
public interface CustomBlockingQueue<Type> {

    void enqueue(Type item) throws InterruptedException;

    Type dequeue() throws InterruptedException;
}
