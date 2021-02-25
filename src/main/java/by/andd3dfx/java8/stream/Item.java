package by.andd3dfx.java8.stream;

public class Item {
    private int x;

    private int y;

    public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Item{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
