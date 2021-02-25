package by.andd3dfx.multithreading.storage.tasks;

import by.andd3dfx.multithreading.storage.model.Storage;
import by.andd3dfx.multithreading.storage.model.Truck;
import java.util.concurrent.ExecutorService;

public abstract class BaseTask implements Runnable {

    protected final Storage storage;
    protected final Truck truck;
    protected final ExecutorService roadExecutor;
    protected final ExecutorService loadExecutor;

    public BaseTask(Storage storage, Truck truck, ExecutorService roadExecutor, ExecutorService loadExecutor) {
        this.storage = storage;
        this.truck = truck;
        this.roadExecutor = roadExecutor;
        this.loadExecutor = loadExecutor;
    }
}
