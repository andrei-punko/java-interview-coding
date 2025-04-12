package by.andd3dfx.cache;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LRUCacheTest {

    @Test
    public void testCache() {
        LRUCache<Integer, Integer> cache = new LRUCache<>(2);
        cache.put(1, 1);
        cache.put(2, 4);
        assertThat(cache.get(1)).isEqualTo(1);
        cache.put(3, 9);    // evicts key 2
        assertThat(cache.get(2)).isNull();
        cache.put(4, 16);    // evicts key 1
        assertThat(cache.get(1)).isNull();
        assertThat(cache.get(3)).isEqualTo(9);
        assertThat(cache.get(4)).isEqualTo(16);
    }

    @Test
    public void testCacheForZeroCapacity() {
        LRUCache<Integer, Integer> cache = new LRUCache<>(0);
        cache.put(2, 4);
        assertThat(cache.get(2)).isNull();
        assertThat(cache.get(1)).isNull();
    }
}
