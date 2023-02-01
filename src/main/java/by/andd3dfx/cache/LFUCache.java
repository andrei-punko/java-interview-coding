package by.andd3dfx.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1. put(key, value) - Set or insert the value
 * if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For
 * the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 * <p>
 * Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to
 * zero when the item is removed.
 * <p>
 * Leetcode task: https://leetcode.com/problems/lfu-cache/
 */
@RequiredArgsConstructor
public class LFUCache {

    private final int capacity;

    private Map<Integer, Integer> map = new HashMap<>();
    private Map<Integer, Item> freqs = new HashMap<>();
    private LinkedHashSet<Integer> keysSet = new LinkedHashSet<>();

    public int get(int key) {
        if (freqs.containsKey(key)) {
            Item item = freqs.get(key);
            freqs.put(key, new Item(item.value, item.hitsCount + 1));
            System.out.println("Added to freq map: " + freqs.get(key));
            keysSet.remove(key);
            keysSet.add(key);

            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (freqs.containsKey(key)) {
            Item item = freqs.get(key);
            freqs.put(key, new Item(item.value, item.hitsCount + 1));
        } else if (freqs.size() == capacity) {
            List<Map.Entry<Integer, Item>> entries = freqs.entrySet().stream()
                .sorted((o1, o2) -> {
                    int delta = o1.getValue().getHitsCount() - o2.getValue().getHitsCount();
                    if (delta != 0) {
                        return delta;
                    }

                    List<Integer> integers = keysSet.stream().collect(Collectors.toList());
                    return integers.indexOf(o1.getKey()) - integers.indexOf(o2.getKey());
                }).collect(Collectors.toList());
            Integer keyToDelete = entries.get(0).getKey();

            System.out.println("Removed from freq map: " + freqs.get(keyToDelete));
            freqs.remove(keyToDelete);
            keysSet.remove(keyToDelete);

            map.remove(keyToDelete);

            freqs.put(key, new Item(value, 0));
            keysSet.add(key);
            System.out.println("Added to freq map: " + freqs.get(key));
        } else {
            freqs.put(key, new Item(value, 0));
            keysSet.add(key);
            System.out.println("Added to freq map: " + freqs.get(key));
        }

        map.put(key, value);
    }

    @Data
    @AllArgsConstructor
    public class Item {
        private Integer value;
        private int hitsCount;
    }
}
