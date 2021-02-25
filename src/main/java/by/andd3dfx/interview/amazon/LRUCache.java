package by.andd3dfx.interview.amazon;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1. put(key, value) - Set or insert the value
 * if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Leetcode task: https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {

    private int capacity;
    private Map<Integer, Integer> map = new HashMap<>();
    private Set<Integer> set = new LinkedHashSet<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (set.contains(key)) {
            set.remove(key);
            set.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (set.contains(key)) {
            set.remove(key);
        } else if (set.size() == capacity) {
            Integer keyToDelete = (Integer) set.toArray()[0];
            set.remove(keyToDelete);
            map.remove(keyToDelete);
        }
        set.add(key);

        map.put(key, value);
    }
}
