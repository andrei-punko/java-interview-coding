package by.andd3dfx.multithreading.storage.tasks;

import static by.andd3dfx.multithreading.storage.util.CustomUtil.customSleep;

import by.andd3dfx.multithreading.storage.model.Storage;
import by.andd3dfx.multithreading.storage.model.Truck;
import java.util.concurrent.ExecutorService;

public class RoadToFirmTask extends BaseTask {

    public RoadToFirmTask(Storage storage, Truck truck, ExecutorService roadExecutor, ExecutorService loadExecutor) {
        super(storage, truck, roadExecutor, loadExecutor);
    }

    @Override
    public void run() {
        System.out.println(truck + " going to firm...");
        customSleep(truck.getTimeInRoad());
        truck.incrementTripsCount();
        truck.incrementTimeSpent(truck.getTimeInRoad());
        System.out.println(truck + " arrived to firm");

        roadExecutor.execute(new RoadToStorageTask(storage, truck, roadExecutor, loadExecutor));
    }
}
