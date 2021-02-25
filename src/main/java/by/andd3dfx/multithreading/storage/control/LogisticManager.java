package by.andd3dfx.multithreading.storage.control;

import by.andd3dfx.multithreading.storage.model.Storage;
import by.andd3dfx.multithreading.storage.model.Truck;
import by.andd3dfx.multithreading.storage.tasks.LoadTruckTask;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class LogisticManager {

    private ThreadPoolExecutor loadExecutor;
    private ThreadPoolExecutor roadExecutor;
    private List<Truck> trucks;
    private Storage storage;

    public LogisticManager(double storageCapacity, int gatesCount, double timeSpendingForOneTonLoad,
        List<Truck> trucks) {
        storage = new Storage(storageCapacity, timeSpendingForOneTonLoad);
        this.trucks = trucks;

        loadExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(gatesCount);
        roadExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(trucks.size());
    }

    public void start() {
        for (Truck truck : trucks) {
            loadExecutor.execute(new LoadTruckTask(storage, truck, roadExecutor, loadExecutor));
        }

        while (hasRunningTasks(loadExecutor) || hasRunningTasks(roadExecutor)) {
        }
        loadExecutor.shutdown();
        roadExecutor.shutdown();
    }

    private boolean hasRunningTasks(ThreadPoolExecutor executor) {
        long submitted = executor.getTaskCount();
        long completed = executor.getCompletedTaskCount();
        long notCompleted = submitted - completed;
        return notCompleted > 0;
    }
}
