package by.andd3dfx.multithreading.forkjoin2;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

// TODO: consider to add of CommonRecursiveTask
//
public abstract class CommonRecursiveAction<T extends IWorkContainer> extends RecursiveAction {

    private final T workload;

    private static Logger logger = Logger.getLogger(CommonRecursiveAction.class.getName());

    public CommonRecursiveAction(T workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.length() > workload.threshold()) {
            ForkJoinTask.invokeAll(workload.createSubtasks());
        } else {
            processing(workload);
        }
    }

    private void processing(T work) {
        process(work);

        String threadName = Thread.currentThread().getName();
        logger.info(String.format("Work (%s) was processed by %s", work, threadName));
    }

    public abstract void process(T work);
}
