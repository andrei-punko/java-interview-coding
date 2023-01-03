package by.andd3dfx.queue;

import lombok.Data;

@Data
public class Item<T extends Number> {
    private T value;
    private Item<T> next;
}
