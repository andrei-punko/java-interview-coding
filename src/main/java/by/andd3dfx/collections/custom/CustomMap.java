package by.andd3dfx.collections.custom;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Draft version of Custom map
 */
public class CustomMap<K, V> implements Map<K, V> {

    public static final int BUCKETS_COUNT = 17;
    private Bucket<K, V>[] buckets;
    private V valueForNullKey;
    private int size;
    private Set<Entry<K, V>> entrySet;

    public CustomMap() {
        buckets = new Bucket[BUCKETS_COUNT];
        for (var i = 0; i < BUCKETS_COUNT; i++) {
            buckets[i] = new Bucket<>();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for (var bucket : buckets) {
            var current = bucket.getHead();
            while (current != null) {
                if (isEquals(value, current.getValue())) {
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    boolean isEquals(Object o1, Object o2) {
        if (o1 == null && o2 == null) {
            return true;
        }
        if (o1 == null || o2 == null) {
            return false;
        }
        return o1.equals(o2);
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            return valueForNullKey;
        }

        int bucketNumber = key.hashCode() % BUCKETS_COUNT;
        CustomEntry<K, V> entry = buckets[bucketNumber].getHead();
        while (entry != null) {
            if (isEquals(key, entry.getKey())) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (key == null) {
            valueForNullKey = value;
            return value;
        }

        int bucketNumber = key.hashCode() % BUCKETS_COUNT;
        CustomEntry entry = new CustomEntry(key, value);

        CustomEntry<K, V> head = buckets[bucketNumber].getHead();
        if (head == null) {
            buckets[bucketNumber].setHead(entry);
            size++;
        } else {
            CustomEntry<K, V> current = head;

            while (current.getNext() != null || !key.equals(current.getKey())) {
                current = current.getNext();
            }

            if (key.equals(current.getKey())) {
                current.setValue(value);
            } else {
                entry.setPrev(current);
                current.setNext(entry);
                size++;
            }
        }
        return value;
    }

    @Override
    public V remove(Object key) {
        int bucketNumber = key.hashCode() % BUCKETS_COUNT;
        CustomEntry<K, V> entry = buckets[bucketNumber].getHead();
        while (entry != null) {
            if (key.equals(entry.getKey())) {
                V result = entry.getValue();
                if (entry.getPrev() != null) {
                    entry.getPrev().setNext(entry.getNext());
                }
                if (entry.getNext() != null) {
                    entry.getNext().setPrev(entry.getPrev());
                }
                return result;
            }
            entry = entry.getNext();
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.entrySet().stream().forEach(entry -> {
            put(entry.getKey(), entry.getValue());
        });
    }

    @Override
    public void clear() {
        buckets = new Bucket[BUCKETS_COUNT];
        for (var i = 0; i < BUCKETS_COUNT; i++) {
            buckets[i] = new Bucket<>();
        }
        valueForNullKey = null;
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        var keys = new HashSet<K>();
        for (var bucket : buckets) {
            var current = bucket.getHead();
            while (current != null) {
                keys.add(current.getKey());
                current = current.getNext();
            }
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        var values = new HashSet<V>();
        for (var bucket : buckets) {
            var current = bucket.getHead();
            while (current != null) {
                values.add(current.getValue());
                current = current.getNext();
            }
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        var entries = new HashSet<Entry<K, V>>();
        for (var bucket : buckets) {
            var current = bucket.getHead();
            while (current != null) {
                entries.add(current);
                current = current.getNext();
            }
        }
        return entries;
    }
}
