package by.andd3dfx.multithreading.forkjoin2;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;
import java.util.stream.Stream;

public abstract class CommonRecursiveTask<T extends CommonRecursiveTask.IWorkContainer, V> extends RecursiveTask<V> {

    private static Logger logger = Logger.getLogger(CommonRecursiveTask.class.getName());

    private final T workload;

    public CommonRecursiveTask(T workload) {
        this.workload = workload;
    }

    @Override
    protected V compute() {
        if (workload.length() <= workload.threshold()) {
            return processNLog(workload);
        }

        return calculateResult(
                ForkJoinTask.invokeAll(workload.createSubtasks())
                        .stream()
                        .map(ForkJoinTask::join)
        );
    }

    public abstract V calculateResult(Stream<Object> objects);

    private V processNLog(T work) {
        String threadName = Thread.currentThread().getName();
        logger.info(String.format("Work (%s) was processed by thread %s", work, threadName));

        return process(work);
    }

    public abstract V process(T work);

    public interface IWorkContainer {

        int length();

        int threshold();

        List<CommonRecursiveTask> createSubtasks();
    }
}
