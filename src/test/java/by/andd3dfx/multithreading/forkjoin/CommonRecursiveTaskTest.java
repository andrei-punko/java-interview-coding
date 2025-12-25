package by.andd3dfx.multithreading.forkjoin;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonRecursiveTaskTest {

    private final int[] WORKLOAD = new int[]{11, 41, 13, 16, 25, 20, 9, 64, 21, 14, 12, 28};
    private final Long EXPECTED_SUM = 274L;

    private ForkJoinPool forkJoinPool;

    @Before
    public void setup() {
        forkJoinPool = ForkJoinPool.commonPool();
    }

    @Test
    public void commonRecursiveTaskViaSubmitOneElement() throws InterruptedException, ExecutionException {
        var commonRecursiveTask = new MyCommonRecursiveTask(new MyWorkContainer(new int[]{5}, 1));

        forkJoinPool.submit(commonRecursiveTask);

        assertThat(commonRecursiveTask.get()).isEqualTo(5L);
    }

    @Test
    public void commonRecursiveTaskViaSubmitTwoElements() throws InterruptedException, ExecutionException {
        var commonRecursiveTask = new MyCommonRecursiveTask(new MyWorkContainer(new int[]{5, 7}, 4));

        forkJoinPool.submit(commonRecursiveTask);

        assertThat(commonRecursiveTask.get()).isEqualTo(12L);
    }

    @Test
    public void testCommonRecursiveTaskViaSubmit() throws InterruptedException, ExecutionException {
        var commonRecursiveTask = new MyCommonRecursiveTask(new MyWorkContainer(WORKLOAD, 4));

        forkJoinPool.submit(commonRecursiveTask);

        assertThat(commonRecursiveTask.get()).isEqualTo(EXPECTED_SUM);
    }

    @Test
    public void testCommonRecursiveTaskViaExecute() throws InterruptedException, ExecutionException {
        var commonRecursiveTask = new MyCommonRecursiveTask(new MyWorkContainer(WORKLOAD, 4));

        forkJoinPool.execute(commonRecursiveTask);

        assertThat(commonRecursiveTask.get()).isEqualTo(EXPECTED_SUM);
    }

    @Test
    public void testCommonRecursiveTaskViaInvoke() throws InterruptedException, ExecutionException {
        var commonRecursiveTask = new MyCommonRecursiveTask(new MyWorkContainer(WORKLOAD, 4));

        forkJoinPool.invoke(commonRecursiveTask);

        assertThat(commonRecursiveTask.get()).isEqualTo(EXPECTED_SUM);
    }

    @Test
    public void testCommonRecursiveTaskViaForkNJoin() throws InterruptedException, ExecutionException {
        var commonRecursiveTask = new MyCommonRecursiveTask(new MyWorkContainer(WORKLOAD, 4));

        commonRecursiveTask.fork();
        commonRecursiveTask.join();

        assertThat(commonRecursiveTask.get()).isEqualTo(EXPECTED_SUM);
    }

    private class MyWorkContainer implements CommonRecursiveTask.IWorkContainer {

        private final int[] workload;
        private final int threshold;

        public MyWorkContainer(int[] workload, int threshold) {
            this.workload = workload;
            this.threshold = threshold;
        }

        @Override
        public int length() {
            return workload.length;
        }

        @Override
        public int threshold() {
            return threshold;
        }

        @Override
        public List<CommonRecursiveTask> createSubtasks() {
            var partOne = Arrays.copyOfRange(workload, 0, workload.length / 2);
            var partTwo = Arrays.copyOfRange(workload, workload.length / 2, workload.length);

            return Arrays.asList(
                new MyCommonRecursiveTask(new MyWorkContainer(partOne, threshold)),
                new MyCommonRecursiveTask(new MyWorkContainer(partTwo, threshold))
            );
        }

        @Override
        public String toString() {
            return String.format("{workload='%s', threshold=%d}", Arrays.toString(workload), threshold);
        }
    }

    private static class MyCommonRecursiveTask extends CommonRecursiveTask<MyWorkContainer, Long> {

        private static Logger logger = Logger.getLogger(MyCommonRecursiveTask.class.getName());

        public MyCommonRecursiveTask(MyWorkContainer workload) {
            super(workload);
        }

        @Override
        public Long calculateResult(Stream<Object> objects) {
            return objects.mapToLong(value -> (Long) value).sum();
        }

        @Override
        public Long process(MyWorkContainer work) {
            var result = Arrays.stream(work.workload).sum();

            String threadName = Thread.currentThread().getName();
            logger.info(String.format("This result of work %s is equals to %d - was processed by thread %s",
                work, result, threadName));
            return (long) result;
        }
    }
}
