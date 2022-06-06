package by.andd3dfx.multithreading.forkjoin2;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

public abstract class CommonRecursiveAction<T extends CommonRecursiveAction.IWorkContainer> extends RecursiveAction {

    private static Logger logger = Logger.getLogger(CommonRecursiveAction.class.getName());

    private final T workload;

    public CommonRecursiveAction(T workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.length() > workload.threshold()) {
            ForkJoinTask.invokeAll(workload.createSubtasks());
        } else {
            processNLog(workload);
        }
    }

    private void processNLog(T work) {
        String threadName = Thread.currentThread().getName();
        logger.info(String.format("Work (%s) was processed by %s", work, threadName));

        process(work);
    }

    public abstract void process(T work);

    public interface IWorkContainer {

        int length();

        int threshold();

        List<CommonRecursiveAction> createSubtasks();
    }
}
