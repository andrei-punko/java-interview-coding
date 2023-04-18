package by.andd3dfx.multithreading.executor;

import by.andd3dfx.multithreading.queue.CustomBlockingQueue;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

/**
 * Dequeue the task from the queue and executes it.
 */
@AllArgsConstructor
public class TaskExecutor implements Runnable {

    private CustomBlockingQueue<Runnable> queue;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            String threadName = Thread.currentThread().getName();
            Runnable task = queue.dequeue();

            System.out.println("Task started by " + threadName);
            task.run();
            System.out.println("Task finished by " + threadName);
        }
    }
}
