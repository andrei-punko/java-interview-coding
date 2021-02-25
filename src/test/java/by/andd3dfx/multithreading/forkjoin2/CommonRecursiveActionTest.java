package by.andd3dfx.multithreading.forkjoin2;

import static java.lang.Thread.sleep;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;

public class CommonRecursiveActionTest {

    private ForkJoinPool forkJoinPool;

    @Before
    public void setup() {
        forkJoinPool = ForkJoinPool.commonPool();
    }

    @Test
    public void testCustomRecursiveActionViaSubmit() throws InterruptedException {
        MyCommonRecursiveAction myCommonRecursiveAction = new MyCommonRecursiveAction(
            new MyWorkContainer("Some very long and boring string", 4)
        );

        forkJoinPool.submit(myCommonRecursiveAction);

        while (!myCommonRecursiveAction.isDone()) {
            sleep(500);
        }
    }

    @Test
    public void testCustomRecursiveActionViaExecute() throws InterruptedException {
        MyCommonRecursiveAction myCommonRecursiveAction = new MyCommonRecursiveAction(
            new MyWorkContainer("Some very long and boring string", 4)
        );

        forkJoinPool.execute(myCommonRecursiveAction);

        while (!myCommonRecursiveAction.isDone()) {
            sleep(500);
        }
    }

    @Test
    public void testCustomRecursiveActionViaInvoke() throws InterruptedException {
        MyCommonRecursiveAction myCommonRecursiveAction = new MyCommonRecursiveAction(
            new MyWorkContainer("Some very long and boring string", 4)
        );

        forkJoinPool.invoke(myCommonRecursiveAction);

        while (!myCommonRecursiveAction.isDone()) {
            sleep(500);
        }
    }

    @Test
    public void testCustomRecursiveActionViaForkNJoin() throws InterruptedException {
        MyCommonRecursiveAction myCommonRecursiveAction = new MyCommonRecursiveAction(
            new MyWorkContainer("Some very long and boring string", 4)
        );

        myCommonRecursiveAction.fork();
        myCommonRecursiveAction.join();

        while (!myCommonRecursiveAction.isDone()) {
            sleep(500);
        }
    }

    private class MyWorkContainer implements IWorkContainer {

        private final String workload;
        private final int threshold;

        public MyWorkContainer(String workload, int threshold) {
            this.workload = workload;
            this.threshold = threshold;
        }

        @Override
        public int length() {
            return workload.length();
        }

        @Override
        public int threshold() {
            return threshold;
        }

        @Override
        public List<CommonRecursiveAction> createSubtasks() {
            String partOne = workload.substring(0, workload.length() / 2);
            String partTwo = workload.substring(workload.length() / 2);

            return Arrays.asList(
                new MyCommonRecursiveAction(new MyWorkContainer(partOne, threshold)),
                new MyCommonRecursiveAction(new MyWorkContainer(partTwo, threshold))
            );
        }

        @Override
        public String toString() {
            return "{" +
                "workload='" + workload + '\'' +
                ", threshold=" + threshold +
                '}';
        }
    }

    private static class MyCommonRecursiveAction extends CommonRecursiveAction<MyWorkContainer> {

        private static Logger logger = Logger.getLogger(MyCommonRecursiveAction.class.getName());

        public MyCommonRecursiveAction(MyWorkContainer workload) {
            super(workload);
        }

        @Override
        public void process(MyWorkContainer work) {
            String result = work.workload.toUpperCase();
            String threadName = Thread.currentThread().getName();

            logger.info(String.format("This result - %s - was processed by %s", result, threadName));
        }
    }
}