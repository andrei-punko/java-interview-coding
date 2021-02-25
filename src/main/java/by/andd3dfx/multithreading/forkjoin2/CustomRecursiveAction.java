package by.andd3dfx.multithreading.forkjoin2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

/**
 * Based on article https://www.baeldung.com/java-fork-join
 */
public class CustomRecursiveAction extends RecursiveAction {

    private static final int LENGTH_THRESHOLD = 4;
    private String workload;

    private static Logger logger = Logger.getAnonymousLogger();

    public CustomRecursiveAction(String workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.length() > LENGTH_THRESHOLD) {
            ForkJoinTask.invokeAll(createSubtasks());
        } else {
            processing(workload);
        }
    }

    private List<CustomRecursiveAction> createSubtasks() {
        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2, workload.length());

        return Arrays.asList(new CustomRecursiveAction(partOne), new CustomRecursiveAction(partTwo));
    }

    private void processing(String work) {
        String result = work.toUpperCase();
        String threadName = Thread.currentThread().getName();

        logger.info(String.format("This result - (%s) - was processed by %s", result, threadName));
    }
}
