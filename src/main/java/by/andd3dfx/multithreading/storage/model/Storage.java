package by.andd3dfx.multithreading.storage.model;

public class Storage {

    private double capacity;
    private final double timeSpendingForOneTonLoad;

    public Storage(double capacity, double timeSpendingForOneTonLoad) {
        this.capacity = capacity;
        this.timeSpendingForOneTonLoad = timeSpendingForOneTonLoad;
    }

    public double getTimeSpendingForOneTonLoad() {
        return timeSpendingForOneTonLoad;
    }

    public synchronized boolean isStorageEmpty() {
        return capacity == 0;
    }

    public synchronized double needToLoadTruck(double loadCapacity) {
        if (capacity >= loadCapacity) {
            capacity = capacity - loadCapacity;
            return loadCapacity;
        }
        double result = capacity;
        capacity = 0;
        return result;
    }
}
