package by.andd3dfx.cache;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/lfu-cache/">Task description</a>
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 *
 * - get(key)           Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return null.
 * - put(key, value)    Set or insert the value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new item.
 * For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency),
 * the least recently used key would be evicted.
 *
 * Note that the number of times an item is used is the number of calls to the get and put functions
 * for that item since it was inserted. This number is set to zero when the item is removed.
 * </pre>
 *
 * @see <a href="https://youtu.be/sZrNyIrwjnc">Video solution</a>
 */
@RequiredArgsConstructor
public class LFUCacheUsingTime<K, V> {

    private final int capacity;
    private Map<K, Item> map = new HashMap<>();

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }

        var item = map.get(key);
        item.lastUsedTime = System.nanoTime();
        item.hitsCount++;
        return item.value;
    }

    public void put(K key, V value) {
        if (capacity == 0) {
            return;
        }

        if (map.containsKey(key)) {
            var item = map.get(key);
            item.value = value;
            item.hitsCount++;
            item.lastUsedTime = System.nanoTime();
            return;
        }

        if (map.size() == capacity) {
            var keyToDelete = determineKeyToDelete();
            map.remove(keyToDelete);
        }

        map.put(key, new Item(value, 0, System.nanoTime()));
    }

    K determineKeyToDelete() {
        return map.entrySet().stream()
                .sorted(Comparator
                        .comparingInt((Map.Entry<K, Item> entry) -> entry.getValue().hitsCount)
                        .thenComparingLong(entry -> entry.getValue().lastUsedTime)
                ).findFirst().get().getKey();
    }

    @AllArgsConstructor
    public class Item {
        private V value;
        private int hitsCount;
        private long lastUsedTime;
    }
}
