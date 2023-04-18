package by.andd3dfx.multithreading.executor;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

/**
 * Simulates the task to be submitted to thread pool executor.
 */
@AllArgsConstructor
public class TestTask implements Runnable {

    private int number;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Start executing of task N=" + number);
        Thread.sleep(50);
        System.out.println("End executing of task N=" + number);
    }
}
