package by.andd3dfx.multithreading.executor;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.Random;

/**
 * Simulates the task to be submitted to thread pool executor.
 */
@RequiredArgsConstructor
public class TestTask implements Runnable {

    private final int taskNumber;
    private static final Random random = new Random();

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("\tStart executing of task №" + taskNumber);
        Thread.sleep(random.nextInt(50));
        System.out.println("\tEnd executing of task №" + taskNumber);
    }
}
