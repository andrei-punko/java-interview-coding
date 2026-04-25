package by.andd3dfx.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/description/">Task description</a>
 *
 * Implement the RandomizedSet class:
 *
 *   RandomizedSet() Initializes the RandomizedSet object.
 *   bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 *   bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 *   int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 *
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 *
 * Example 1:
 *   Input
 *   ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 *   [[], [1], [2], [2], [], [1], [2], []]
 *   Output
 *   [null, true, false, true, 2, true, false, 2]
 *
 * Explanation
 *   RandomizedSet randomizedSet = new RandomizedSet();
 *   randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 *   randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 *   randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 *   randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 *   randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 *   randomizedSet.insert(2); // 2 was already in the set, so return false.
 *   randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 * </pre>
 */
public class RandomizedSet {

    private final Random random = new Random();
    private final Map<Integer, Integer> map = new HashMap<>();
    private final List<Integer> keys = new ArrayList<>();

    /**
     * Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
     */
    public boolean insert(int val) {
        var isNotExist = !map.containsKey(val);
        if (isNotExist) {
            keys.add(val);
            map.put(val, keys.size() - 1);
        }
        return isNotExist;
    }

    /**
     * Removes an item val from the set if present. Returns true if the item was present, false otherwise.
     */
    public boolean remove(int val) {
        var isExist = map.containsKey(val);
        if (isExist) {
            var index = map.get(val);
            keys.set(index, keys.getLast());
            map.put(keys.get(index), index);
            keys.removeLast();
            map.remove(val);
        }
        return isExist;
    }

    /**
     * Returns a random element from the current set of elements (it's guaranteed that at least one element exists
     * when this method is called). Each element must have the same probability of being returned.
     */
    public int getRandom() {
        var index = random.nextInt(keys.size());
        return keys.get(index);
    }
}
