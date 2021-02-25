package by.andd3dfx.multithreading.threadpool;

/*
    1.TaskExecutor class implements Runnable interface.
    2.The method of TaskExecutor class dequeue the task from the queue (BlockingQueue)
    3.TaskExecutor class executes the task.
 */
public class TaskExecutor implements Runnable {

    private CustomBlockingQueue<Runnable> queue;

    public TaskExecutor(CustomBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String threadName = Thread.currentThread().getName();
                Runnable task = queue.dequeue();

                System.out.println("Task started by Thread: " + threadName);
                task.run();
                System.out.println("Task finished by Thread: " + threadName);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
