package by.andd3dfx.multithreading.executor;

import by.andd3dfx.multithreading.queue.CustomBlockingQueue;
import by.andd3dfx.multithreading.queue.SynchronizedBlocksBasedBlockingQueue;
import lombok.SneakyThrows;

/**
 * <pre>
 * Write custom implementation of ThreadPoolExecutor that support next 2 methods: submit(Runnable) and shutdown().
 *
 * ThreadPoolExecutor creates numbers of TaskExecutor instances.
 * TaskExecutor will be responsible for executing tasks.
 * TaskExecutor exposes method submit() which will be called by task generating program, to submit a task.
 *
 * Based on http://www.makeinjava.com/custom-thread-pool-example-without-using-executor-framework/
 * </pre>
 */
public class CustomThreadPoolExecutor {

    private static final int QUEUE_SIZE = 100;
    private CustomBlockingQueue<Runnable> queue;
    private volatile boolean isStopped = false;

    public CustomThreadPoolExecutor(int threadsCount) {
        queue = new SynchronizedBlocksBasedBlockingQueue<>(QUEUE_SIZE);

        for (int i = 0; i < threadsCount; i++) {
            TaskExecutor taskExecutor = new TaskExecutor(queue);
            Thread thread = new Thread(taskExecutor, "Thread-" + i);
            thread.start();
        }
    }

    @SneakyThrows
    public boolean submit(Runnable task) {
        if (isStopped) {
            System.out.println("Task rejected because of shutdown state");
            return false;
        }

        queue.enqueue(task);
        return true;
    }

    /**
     * In shutdown state Thread Pool stops accepting new tasks
     */
    public void shutdown() {
        isStopped = true;
    }
}
