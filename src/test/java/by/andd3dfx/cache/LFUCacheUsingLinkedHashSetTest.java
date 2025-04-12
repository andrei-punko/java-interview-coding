package by.andd3dfx.cache;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LFUCacheUsingLinkedHashSetTest {

    @Test
    public void testCacheWithZeroCapacity() {
        LFUCacheUsingLinkedHashSet<Integer, Integer> cache = new LFUCacheUsingLinkedHashSet<>(0);

        assertThat(cache.get(2)).isNull();
        cache.put(2, 67);
        assertThat(cache.get(2)).isNull();
    }

    @Test
    public void testCache() {
        LFUCacheUsingLinkedHashSet<Integer, Integer> cache = new LFUCacheUsingLinkedHashSet<>(2);
        cache.put(1, 10);
        cache.put(2, 20);
        assertThat(cache.get(1)).isEqualTo(10);

        cache.put(3, 30);   //evicts key 2

        assertThat(cache.get(2)).isNull();
        assertThat(cache.get(3)).isEqualTo(30);

        cache.put(4, 40);   //evicts key 1

        assertThat(cache.get(1)).isNull();
        assertThat(cache.get(3)).isEqualTo(30);
        assertThat(cache.get(4)).isEqualTo(40);
    }

    @Test
    public void testCacheComplex() {
        LFUCacheUsingLinkedHashSet<Integer, Integer> cache = new LFUCacheUsingLinkedHashSet<>(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        assertThat(cache.get(1)).isEqualTo(10);
        assertThat(cache.get(3)).isEqualTo(30);
        assertThat(cache.get(1)).isEqualTo(10);
        assertThat(cache.get(1)).isEqualTo(10);   // 1 -> 3 times used
        assertThat(cache.get(3)).isEqualTo(30);   // 3 -> 2 times used
        assertThat(cache.get(2)).isEqualTo(20);   // 2 -> 1 times used

        cache.put(4, 40);   // evicts key 2 (less used)

        assertThat(cache.get(1)).isEqualTo(10);   // 1 -> 4 times used
        assertThat(cache.get(2)).isNull();
        assertThat(cache.get(4)).isEqualTo(40);
        assertThat(cache.get(4)).isEqualTo(40);
        assertThat(cache.get(4)).isEqualTo(40);   // 4 -> 3 times used
        assertThat(cache.get(3)).isEqualTo(30);   // 3 -> 3 times used

        cache.put(5, 50);   // evicts key 4 (same used as 3, but 3 is last used)

        assertThat(cache.get(1)).isEqualTo(10);
        assertThat(cache.get(2)).isNull();
        assertThat(cache.get(3)).isEqualTo(30);
        assertThat(cache.get(4)).isNull();
        assertThat(cache.get(5)).isEqualTo(50);
    }

    @Test
    public void testCacheLeetCode_updateValue() {
        var cache = new LFUCacheUsingLinkedHashSet<Integer, Integer>(2);
        cache.put(3, 1);
        cache.put(2, 1);
        cache.put(2, 2);    // overwrites value for key 2
        cache.put(4, 4);    // evicts key 3
        assertThat(cache.get(2)).isEqualTo(2);
    }

    @Test
    public void determineKeyToDelete() {
        var cache = new LFUCacheUsingLinkedHashSet<Integer, Integer>(2);
        cache.put(2, 100);
        cache.put(3, 200);
        assertThat(cache.determineKeyToDelete()).isEqualTo(2);

        cache.get(2);
        assertThat(cache.determineKeyToDelete()).isEqualTo(3);
        cache.get(3);
        assertThat(cache.determineKeyToDelete()).isEqualTo(2);
        cache.put(4, 500);
        assertThat(cache.determineKeyToDelete()).isEqualTo(4);
        cache.get(4);
        assertThat(cache.determineKeyToDelete()).isEqualTo(3);
    }
}
