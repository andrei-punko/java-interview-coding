package by.andd3dfx.multithreading.storage.model;

public class Truck {

    private final double loadCapacity;
    private final double timeInRoad;
    private int tripsCount = 0;
    private double timeSpent = 0.0;

    public Truck(double loadCapacity, double timeInRoad) {
        this.loadCapacity = loadCapacity;
        this.timeInRoad = timeInRoad;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public double getTimeInRoad() {
        return timeInRoad;
    }

    public int getTripsCount() {
        return tripsCount;
    }

    public double getTimeSpent() {
        return timeSpent;
    }

    public synchronized void incrementTripsCount() {
        tripsCount++;
    }

    public synchronized void incrementTimeSpent(double deltaInMinutes) {
        timeSpent += deltaInMinutes;
    }

    @Override
    public String toString() {
        return "Truck{" +
            "loadCapacity=" + loadCapacity +
            ", timeInRoad=" + timeInRoad +
            ", tripsCount=" + tripsCount +
            ", timeSpent=" + timeSpent +
            '}';
    }
}
