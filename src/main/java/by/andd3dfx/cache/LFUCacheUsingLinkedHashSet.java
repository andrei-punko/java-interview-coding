package by.andd3dfx.cache;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
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
 * @see <a href="https://youtu.be/4hhu0cSVUCA">Video solution</a>
 */
@Slf4j
@RequiredArgsConstructor
public class LFUCacheUsingLinkedHashSet<K, V> {

    private final int capacity;
    private Map<K, Item> map = new HashMap<>();
    private LinkedHashSet<K> keySet = new LinkedHashSet<>();

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }

        Item item = map.get(key);
        item.hitsCount++;
        log.debug("GET: increased hits counter for key={}", key);

        keySet.remove(key);
        keySet.add(key);

        return item.value;
    }

    public void put(K key, V value) {
        if (capacity == 0) {
            return;
        }

        if (map.containsKey(key)) {
            Item item = map.get(key);
            item.value = value;
            item.hitsCount++;
            log.debug("PUT: increased hits counter for key={}", key);
            return;
        }

        if (map.size() == capacity) {
            K keyToDelete = determineKeyToDelete();
            map.remove(keyToDelete);
            keySet.remove(keyToDelete);
        }

        map.put(key, new Item(value, 0));
        keySet.add(key);
        log.debug("PUT: added counter for key={}", key);
    }

    K determineKeyToDelete() {
        List<K> keys = keySet.stream().toList();
        return map.entrySet().stream()
            .sorted((o1, o2) -> {
                int delta = o1.getValue().hitsCount - o2.getValue().hitsCount;
                if (delta != 0) {
                    return delta;
                }

                return keys.indexOf(o1.getKey()) - keys.indexOf(o2.getKey());
            }).findFirst().get().getKey();
    }

    @AllArgsConstructor
    public class Item {
        private V value;
        private int hitsCount;
    }
}
