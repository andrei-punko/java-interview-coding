package by.andd3dfx.collections.custom;

import lombok.Data;

import java.util.Map;

@Data
public class CustomEntry<K, V> implements Map.Entry<K, V> {

    private final K key;
    private V value;
    private CustomEntry<K, V> prev;
    private CustomEntry<K, V> next;

    @Override
    public V setValue(V value) {
        this.value = value;
        return value;
    }

    public CustomEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
