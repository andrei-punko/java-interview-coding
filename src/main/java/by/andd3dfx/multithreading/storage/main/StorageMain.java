package by.andd3dfx.multithreading.storage.main;

import by.andd3dfx.multithreading.storage.control.LogisticManager;
import by.andd3dfx.multithreading.storage.model.Truck;
import by.andd3dfx.multithreading.storage.util.CustomUtil;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StorageMain {

    public static void main(String[] args) {
        List<Truck> trucks = Arrays.asList(
            new Truck(1.5, 30),
            new Truck(3.4, 45),
            new Truck(5.1, 40)
        );

        LogisticManager logisticManager = new LogisticManager(3.5, 2, 3.0, trucks);
        logisticManager.start();
        System.out.println(trucks);

        List<Integer> tripsCounts = trucks.stream().map(Truck::getTripsCount).collect(Collectors.toList());
        System.out.printf("Total trips count: %s%n", tripsCounts);
        System.out.printf("Time spent for moving all cargo: %s min%n", CustomUtil.extractMaxTruckTime(trucks));
    }
}
