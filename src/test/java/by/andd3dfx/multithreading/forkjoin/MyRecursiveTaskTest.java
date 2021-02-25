package by.andd3dfx.multithreading.forkjoin;

import java.util.concurrent.ForkJoinPool;
import org.junit.Test;

public class MyRecursiveTaskTest {

  @Test
  public void compute() {

    MyRecursiveTask myRecursiveTask = new MyRecursiveTask(128);
    ForkJoinPool forkJoinPool = new ForkJoinPool(4);
    long mergedResult = forkJoinPool.invoke(myRecursiveTask);
    System.out.println("mergedResult = " + mergedResult);
  }
}
