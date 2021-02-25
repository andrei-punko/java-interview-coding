package by.andd3dfx.multithreading.forkjoin2;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

/**
 * Based on article https://www.baeldung.com/java-fork-join
 */
public class CustomRecursiveTask extends RecursiveTask<Integer> {

    private static final int LENGTH_THRESHOLD = 4;
    private int[] arr;
    private static Logger logger = Logger.getAnonymousLogger();

    public CustomRecursiveTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        if (arr.length <= LENGTH_THRESHOLD) {
            Integer processingResult = processing(arr);
            logger.info(String.format("Processed %s with result: %d", Arrays.toString(arr), processingResult));
            return processingResult;
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

    private Integer processing(int[] arr) {
        return Arrays.stream(arr)
            .filter(a -> a > 10 && a < 27)
            .map(a -> a * 10)
            .sum();
    }
}
