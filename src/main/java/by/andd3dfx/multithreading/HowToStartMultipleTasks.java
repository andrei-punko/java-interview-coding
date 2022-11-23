package by.andd3dfx.multithreading;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

@Slf4j
public class HowToStartMultipleTasks {

    public void usingThreads() {
        var thread1 = new Thread(() -> { log.info("--- usingThreads: Make action 1"); });
        var thread2 = new Thread(() -> { log.info("--- usingThreads: Make action 2"); });
        var thread3 = new Thread(() -> { log.info("--- usingThreads: Make action 3"); });
        var thread4 = new Thread(() -> { log.info("--- usingThreads: Make action 4"); });
        var thread5 = new Thread(() -> { log.info("--- usingThreads: Make action 5"); });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    public void usingCompletableFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> { log.info("    usingCompletableFuture: Make action 1"); }),
                CompletableFuture.runAsync(() -> { log.info("    usingCompletableFuture: Make action 2"); }),
                CompletableFuture.runAsync(() -> { log.info("    usingCompletableFuture: Make action 3"); }),
                CompletableFuture.runAsync(() -> { log.info("    usingCompletableFuture: Make action 4"); }),
                CompletableFuture.runAsync(() -> { log.info("    usingCompletableFuture: Make action 5"); })
        );
        combinedFuture.get();
    }

    public void usingForkJoinTask() {
        ForkJoinTask.invokeAll(
                new RecursiveAction() {
                    @Override
                    protected void compute() {
                        // Make action 1
                        log.info("usingForkJoinTask: Make action 1");
                    }
                }, new RecursiveTask() {
                    @Override
                    protected Object compute() {
                        // Add result 2 computation
                        log.info("usingForkJoinTask: Make action 2");
                        return null;
                    }
                },
                new RecursiveTask() {
                    @Override
                    protected Object compute() {
                        // Add result 3 computation
                        log.info("usingForkJoinTask: Make action 3");
                        return null;
                    }
                },
                new RecursiveTask() {
                    @Override
                    protected Object compute() {
                        // Add result 4 computation
                        log.info("usingForkJoinTask: Make action 4");
                        return null;
                    }
                },
                new RecursiveTask() {
                    @Override
                    protected Object compute() {
                        // Add result 5 computation
                        log.info("usingForkJoinTask: Make action 5");
                        return null;
                    }
                }
        );
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HowToStartMultipleTasks starter = new HowToStartMultipleTasks();
        starter.usingThreads();
        starter.usingCompletableFuture();
        starter.usingForkJoinTask();
    }
}
