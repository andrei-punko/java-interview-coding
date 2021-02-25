package by.andd3dfx.multithreading.forkjoin;

import java.util.concurrent.ForkJoinPool;
import org.junit.Test;

public class MyRecursiveActionTest {

  @Test
  public void compute() {
    MyRecursiveAction myRecursiveAction = new MyRecursiveAction(24);
    ForkJoinPool forkJoinPool = new ForkJoinPool(4);
    forkJoinPool.invoke(myRecursiveAction);
  }
}
