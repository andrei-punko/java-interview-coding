package by.andd3dfx.collections.custom;

public class CustomHashMap<K, V> {

    private static final int BUCKETS_COUNT = 16;

    private CustomLinkedList<CustomEntry<K, V>>[] buckets;
    private V valueForNullKey;
    private int size = 0;

    public CustomHashMap() {
        initialize();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(Object key) {
        if (key == null) {
            return valueForNullKey;
        }

        int bucketNumber = key.hashCode() % BUCKETS_COUNT;
        if (buckets[bucketNumber].isEmpty()) {
            return null;
        }

        for (var curr : buckets[bucketNumber]) {
            if (checkEquality(key, curr.getKey())) {
                return curr.getValue();
            }
        }
        return null;
    }

    public V put(K key, V value) {
        if (key == null) {
            valueForNullKey = value;
            return value;
        }

        int bucketNumber = key.hashCode() % BUCKETS_COUNT;

        if (buckets[bucketNumber].isEmpty()) {
            buckets[bucketNumber].add(new CustomEntry(key, value));
            size++;
            return value;
        }

        for (var curr : buckets[bucketNumber]) {
            if (checkEquality(key, curr.getKey())) {
                curr.setValue(value);
                return value;
            }
        }

        buckets[bucketNumber].add(new CustomEntry(key, value));
        size++;
        return value;
    }

    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    public boolean containsValue(Object value) {
        for (var bucket : buckets) {
            for (var curr : bucket) {
                if (checkEquality(value, curr.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    public V remove(Object key) {
        if (key == null) {
            var result = valueForNullKey;
            valueForNullKey = null;
            size--;
            return result;
        }

        int bucketNumber = key.hashCode() % BUCKETS_COUNT;
        for (var curr : buckets[bucketNumber]) {
            if (checkEquality(key, curr.getKey())) {
                final V result = curr.getValue();
                buckets[bucketNumber].remove(curr);
                size--;
                return result;
            }
        }
        return null;
    }

    public void clear() {
        initialize();
    }

    private boolean checkEquality(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        }
        return o1.equals(o2);
    }

    private void initialize() {
        buckets = new CustomLinkedList[BUCKETS_COUNT];
        for (var i = 0; i < BUCKETS_COUNT; i++) {
            buckets[i] = new CustomLinkedList<>();
        }
        valueForNullKey = null;
        size = 0;
    }
}
