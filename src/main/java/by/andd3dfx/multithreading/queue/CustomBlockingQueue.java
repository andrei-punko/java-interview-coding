package by.andd3dfx.multithreading.queue;

/**
 * <pre>
 * Implement BlockingQueue with methods:
 * - enqueue: push task to the queue
 * - dequeue: takes/pop task from the queue.
 * </pre>
 *
 * @see <a href="https://youtu.be/eMn_KjkFGds">Video solution</a>
 */
public interface CustomBlockingQueue<Type> {

    void enqueue(Type item) throws InterruptedException;

    Type dequeue() throws InterruptedException;
}
