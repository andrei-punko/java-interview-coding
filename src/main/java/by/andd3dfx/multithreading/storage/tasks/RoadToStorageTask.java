package by.andd3dfx.multithreading.storage.tasks;

import static by.andd3dfx.multithreading.storage.util.CustomUtil.customSleep;

import by.andd3dfx.multithreading.storage.model.Storage;
import by.andd3dfx.multithreading.storage.model.Truck;
import java.util.concurrent.ExecutorService;

public class RoadToStorageTask extends BaseTask {

    public RoadToStorageTask(Storage storage, Truck truck, ExecutorService roadExecutor, ExecutorService loadExecutor) {
        super(storage, truck, roadExecutor, loadExecutor);
    }

    @Override
    public void run() {
        if (storage.isStorageEmpty()) {
            System.out.println("Storage empty already, so not need to send truck " + truck + " to storage");
            return;
        }

        System.out.println(truck + " going to storage...");
        customSleep(truck.getTimeInRoad());
        truck.incrementTripsCount();
        truck.incrementTimeSpent(truck.getTimeInRoad());
        System.out.println(truck + " arrived to storage");

        loadExecutor.execute(new LoadTruckTask(storage, truck, roadExecutor, loadExecutor));
    }
}
