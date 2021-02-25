package by.andd3dfx.queue;

public class Item<T extends Number> {
    private T value;
    private Item<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }
}
