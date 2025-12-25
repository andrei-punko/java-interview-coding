package by.andd3dfx.multithreading.forkjoin;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

/**
 * Based on <a href="https://www.baeldung.com/java-fork-join">article</a>
 */
public class CustomRecursiveTask extends RecursiveTask<Integer> {

    private static final Logger logger = Logger.getLogger(CustomRecursiveTask.class.getName());

    private static final int LENGTH_THRESHOLD = 4;
    private int[] arr;

    public CustomRecursiveTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        if (arr.length <= LENGTH_THRESHOLD) {
            return processNLog(arr);
        }

        return ForkJoinTask.invokeAll(createSubtasks())
            .stream()
            .mapToInt(ForkJoinTask::join)
            .sum();
    }

    private Collection<CustomRecursiveTask> createSubtasks() {
        int[] leftArray = Arrays.copyOfRange(this.arr, 0, arr.length / 2);
        int[] rightArray = Arrays.copyOfRange(this.arr, this.arr.length / 2, this.arr.length);

        return Arrays.asList(new CustomRecursiveTask(leftArray), new CustomRecursiveTask(rightArray));
    }

    private Integer processNLog(int[] arr) {
        String threadName = Thread.currentThread().getName();
        logger.info(String.format("Work (%s) was processed by thread %s", Arrays.toString(arr), threadName));

        int result = process(arr);
        logger.info(String.format("Processed %s with result: %d", Arrays.toString(arr), result));
        return result;
    }

    private int process(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
