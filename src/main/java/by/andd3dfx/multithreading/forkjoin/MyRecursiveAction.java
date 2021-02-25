package by.andd3dfx.multithreading.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Based on http://tutorials.jenkov.com/java-util-concurrent/java-fork-and-join-forkjoinpool.html
 */
public class MyRecursiveAction extends RecursiveAction {

  private long workLoad = 0;

  public MyRecursiveAction(long workLoad) {
    this.workLoad = workLoad;
  }

  @Override
  protected void compute() {

    //if work is above threshold, break tasks up into smaller tasks
    if (this.workLoad > 16) {
      System.out.println("Splitting workLoad : " + this.workLoad);

      List<MyRecursiveAction> subtasks = new ArrayList<>();
      subtasks.addAll(createSubtasks());

      for (RecursiveAction subtask : subtasks) {
        subtask.fork();
      }

    } else {
      System.out.println("Doing workLoad myself: " + this.workLoad);
    }
  }

  private List<MyRecursiveAction> createSubtasks() {
    List<MyRecursiveAction> subtasks = new ArrayList<>();

    MyRecursiveAction subtask1 = new MyRecursiveAction(this.workLoad / 2);
    MyRecursiveAction subtask2 = new MyRecursiveAction(this.workLoad / 2);

    subtasks.add(subtask1);
    subtasks.add(subtask2);

    return subtasks;
  }
}
