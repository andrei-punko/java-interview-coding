package by.andd3dfx.multithreading.forkjoin2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import org.junit.Before;
import org.junit.Test;

public class CustomRecursiveTaskTest {

    private final int[] WORKLOAD = new int[]{11, 41, 13, 16, 25, 20, 9, 64, 21, 14, 12, 28};
    private final int EXPECTED_SUM = 274;

    private ForkJoinPool forkJoinPool;

    @Before
    public void setup() {
        forkJoinPool = ForkJoinPool.commonPool();
    }

    @Test
    public void testCustomRecursiveTaskViaSubmit() throws InterruptedException, ExecutionException {
        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(WORKLOAD);

        forkJoinPool.submit(customRecursiveTask);

        assertThat(customRecursiveTask.get(), is(EXPECTED_SUM));
    }

    @Test
    public void testCustomRecursiveTaskViaExecute() throws InterruptedException, ExecutionException {
        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(WORKLOAD);

        forkJoinPool.execute(customRecursiveTask);

        assertThat(customRecursiveTask.get(), is(EXPECTED_SUM));
    }

    @Test
    public void testCustomRecursiveTaskViaInvoke() throws InterruptedException, ExecutionException {
        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(WORKLOAD);

        forkJoinPool.invoke(customRecursiveTask);

        assertThat(customRecursiveTask.get(), is(EXPECTED_SUM));
    }

    @Test
    public void testCustomRecursiveTaskViaForkNJoin() throws InterruptedException, ExecutionException {
        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(WORKLOAD);

        customRecursiveTask.fork();
        customRecursiveTask.join();

        assertThat(customRecursiveTask.get(), is(EXPECTED_SUM));
    }
}
