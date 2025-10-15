package by.andd3dfx.collections.custom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @see <a href="https://youtu.be/-GECqwRV8Uw">Video solution</a>
 */
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

        int bucketNumber = determineBucketNumber(key);
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
            V oldValue = valueForNullKey;
            valueForNullKey = value;
            return oldValue;
        }

        int bucketNumber = determineBucketNumber(key);
        if (buckets[bucketNumber].isEmpty()) {
            buckets[bucketNumber].add(new CustomEntry<>(key, value));
            size++;
            return null;
        }

        for (var curr : buckets[bucketNumber]) {
            if (checkEquality(key, curr.getKey())) {
                V oldValue = curr.getValue();
                curr.setValue(value);
                return oldValue;
            }
        }

        buckets[bucketNumber].add(new CustomEntry<>(key, value));
        size++;
        return null;
    }

    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    public boolean containsValue(V value) {
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

        int bucketNumber = determineBucketNumber(key);
        var bucket = buckets[bucketNumber];
        var iterator = bucket.iterator();
        int index = 0;
        
        while (iterator.hasNext()) {
            var curr = iterator.next();
            if (checkEquality(key, curr.getKey())) {
                final V result = curr.getValue();
                bucket.remove(index);
                size--;
                return result;
            }
            index++;
        }
        return null;
    }

    public void clear() {
        initialize();
    }

    public CustomHashSet<K> keySet() {
        CustomHashSet<K> result = new CustomHashSet<>();
        for (var iterator = keyIterator(); iterator.hasNext(); ) {
            result.add(iterator.next());
        }
        return result;
    }

    Iterator<K> keyIterator() {
        return new KeyIterator<>(buckets);
    }

    private int determineBucketNumber(Object key) {
        return Math.abs(key.hashCode() % BUCKETS_COUNT);
    }

    private class KeyIterator<E> implements Iterator<E> {
        private final CustomLinkedList<CustomEntry<E, V>>[] buckets;
        private int currentBucketIndex;
        private Iterator<CustomEntry<E, V>> currentIterator;
        private CustomEntry<E, V> lastReturned;
        private boolean canRemove = false;

        public KeyIterator(CustomLinkedList<CustomEntry<E, V>>[] buckets) {
            this.buckets = buckets;
            currentBucketIndex = 0;
            currentIterator = buckets[currentBucketIndex].iterator();
        }

        @Override
        public boolean hasNext() {
            if (currentIterator.hasNext()) {
                return true;
            }
            if (currentBucketIndex < buckets.length - 1) {
                currentBucketIndex++;
                currentIterator = buckets[currentBucketIndex].iterator();
                return hasNext();
            }
            return false;
        }

        @Override
        public E next() {
            if (currentIterator.hasNext()) {
                lastReturned = currentIterator.next();
                canRemove = true;
                return lastReturned.getKey();
            }
            if (currentBucketIndex < buckets.length - 1) {
                currentBucketIndex++;
                currentIterator = buckets[currentBucketIndex].iterator();
                return next();
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("remove() can only be called after next()");
            }
            if (lastReturned != null) {
                // Находим индекс элемента в текущем bucket и удаляем его
                var bucket = buckets[currentBucketIndex];
                var iterator = bucket.iterator();
                int index = 0;
                while (iterator.hasNext()) {
                    var curr = iterator.next();
                    if (curr == lastReturned) {
                        bucket.remove(index);
                        size--;
                        canRemove = false;
                        return;
                    }
                    index++;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var bucket : buckets) {
            for (var item : bucket) {
                sb.append("%s->%s, ".formatted(item.getKey(), item.getValue()));
            }
        }
        return "{" + sb.substring(0, sb.length() - 2) + "}";
    }

    private boolean checkEquality(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        }
        return o1.equals(o2);
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
        buckets = new CustomLinkedList[BUCKETS_COUNT];
        for (var i = 0; i < BUCKETS_COUNT; i++) {
            buckets[i] = new CustomLinkedList<>();
        }
        valueForNullKey = null;
        size = 0;
    }
}
