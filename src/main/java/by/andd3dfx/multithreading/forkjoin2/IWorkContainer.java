package by.andd3dfx.multithreading.forkjoin2;

import java.util.List;

public interface IWorkContainer {

    int length();

    int threshold();

    List<CommonRecursiveAction> createSubtasks();
}
