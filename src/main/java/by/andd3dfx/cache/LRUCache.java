package by.andd3dfx.cache;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * https://leetcode.com/problems/lru-cache/
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
 */
@RequiredArgsConstructor
public class LRUCache {

    private final int capacity;
    private Map<Integer, Integer> map = new HashMap<>();
    private Set<Integer> set = new LinkedHashSet<>();

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        set.remove(key);
        set.add(key);
        return map.get(key);
    }

    public void put(int key, int value) {
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
