package by.andd3dfx.multithreading.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class JavaBlockingQueueTest extends AbstractBlockingQueueTest {

    @Override
    protected CustomBlockingQueue<QueueItem> buildQueue(int size) {
        return new JavaBlockingQueue(size);
    }

    public class JavaBlockingQueue<T> implements CustomBlockingQueue<T> {
        private LinkedBlockingQueue queue;

        public JavaBlockingQueue(int size) {
            queue = new LinkedBlockingQueue(size);
        }

        @Override
        public void enqueue(T item) throws InterruptedException {
            queue.put(item);
        }

        @Override
        public T dequeue() throws InterruptedException {
            return (T) queue.take();
        }
    }
}
