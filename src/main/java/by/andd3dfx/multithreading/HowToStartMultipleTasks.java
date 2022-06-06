package by.andd3dfx.multithreading;

import java.util.concurrent.*;
import java.util.logging.Logger;

public class HowToStartMultipleTasks {

    private static Logger logger = Logger.getLogger(HowToStartMultipleTasks.class.getName());

    public void way1() {
        ForkJoinTask.invokeAll(
                new RecursiveAction() {
                    @Override
                    protected void compute() {
                        // Make action 1
                        logger.info("way1: Make action 1");
                    }
                }, new RecursiveTask() {
                    @Override
                    protected Object compute() {
                        // Add result 2 computation
                        logger.info("way1: Make action 2");
                        return null;
                    }
                },
                new RecursiveTask() {
                    @Override
                    protected Object compute() {
                        // Add result 3 computation
                        logger.info("way1: Make action 3");
                        return null;
                    }
                },
                new RecursiveTask() {
                    @Override
                    protected Object compute() {
                        // Add result 4 computation
                        logger.info("way1: Make action 4");
                        return null;
                    }
                },
                new RecursiveTask() {
                    @Override
                    protected Object compute() {
                        // Add result 5 computation
                        logger.info("way1: Make action 5");
                        return null;
                    }
                }
        );
    }

    public void way2() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> { logger.info("    way2: Make action 1"); }),
                CompletableFuture.runAsync(() -> { logger.info("    way2: Make action 2"); }),
                CompletableFuture.runAsync(() -> { logger.info("    way2: Make action 3"); }),
                CompletableFuture.runAsync(() -> { logger.info("    way2: Make action 4"); }),
                CompletableFuture.runAsync(() -> { logger.info("    way2: Make action 5"); })
        );
        combinedFuture.get();
    }

    public void way3() {
        var thread1 = new Thread(() -> { logger.info("--- way3: Make action 1"); });
        var thread2 = new Thread(() -> { logger.info("--- way3: Make action 2"); });
        var thread3 = new Thread(() -> { logger.info("--- way3: Make action 3"); });
        var thread4 = new Thread(() -> { logger.info("--- way3: Make action 4"); });
        var thread5 = new Thread(() -> { logger.info("--- way3: Make action 5"); });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HowToStartMultipleTasks starter = new HowToStartMultipleTasks();
        starter.way1();
        starter.way2();
        starter.way3();
    }
}
