package by.andd3dfx.cache;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/lru-cache/">Task description</a>
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 *
 * It should support the following operations: get and put:
 * - get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * - put(key, value) - Set or insert the value
 *
 * If the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 * <pre/>
 *
 * @see <a href="https://youtu.be/ZrF5s4_jNZk">Video solution</a>
 */
@RequiredArgsConstructor
public class LRUCache<K, V> {

    private final int capacity;
    private Map<K, V> map = new HashMap<>();
    private Set<K> set = new LinkedHashSet<>();

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        set.remove(key);
        set.add(key);
        return map.get(key);
    }

    public void put(K key, V value) {
        if (capacity == 0) {
            return;
        }

        if (set.contains(key)) {
            set.remove(key);
        } else if (set.size() == capacity) {
            var keyToDelete = set.toArray()[0];
            set.remove(keyToDelete);
            map.remove(keyToDelete);
        }
        set.add(key);

        map.put(key, value);
    }
}
