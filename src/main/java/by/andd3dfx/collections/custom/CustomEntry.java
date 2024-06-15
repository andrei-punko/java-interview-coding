package by.andd3dfx.collections.custom;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @see CustomHashMap
 */
@Data
@AllArgsConstructor
public class CustomEntry<K, V> {

    private final K key;
    private V value;
}
