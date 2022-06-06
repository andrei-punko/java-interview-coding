package by.andd3dfx.multithreading.forkjoin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

/**
 * Based on article https://www.baeldung.com/java-fork-join
 */
public class CustomRecursiveAction extends RecursiveAction {

    private static Logger logger = Logger.getLogger(CustomRecursiveAction.class.getName());

    private static final int LENGTH_THRESHOLD = 4;
    private String workload;

    public CustomRecursiveAction(String workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.length() > LENGTH_THRESHOLD) {
            ForkJoinTask.invokeAll(createSubtasks());
        } else {
            processNLong(workload);
        }
    }

    private List<CustomRecursiveAction> createSubtasks() {
        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2, workload.length());

        return Arrays.asList(new CustomRecursiveAction(partOne), new CustomRecursiveAction(partTwo));
    }

    private void processNLong(String work) {
        String threadName = Thread.currentThread().getName();
        logger.info(String.format("Work (%s) was processed by thread %s", work, threadName));

        String result = process(work);
        logger.info(String.format("Processed %s with result: %s", work, result));
    }

    private String process(String work) {
        return work.toUpperCase();
    }
}
