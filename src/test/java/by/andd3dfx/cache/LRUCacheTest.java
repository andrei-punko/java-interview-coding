package by.andd3dfx.cache;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void testCache() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 4);
        assertThat(cache.get(1), is(1));
        cache.put(3, 9);    // evicts key 2
        assertThat(cache.get(2), is(-1));
        cache.put(4, 16);    // evicts key 1
        assertThat(cache.get(1), is(-1));
        assertThat(cache.get(3), is(9));
        assertThat(cache.get(4), is(16));
    }

    @Test
    public void testCacheForZeroCapacity() {
        LRUCache cache = new LRUCache(0);
        cache.put(2, 4);
        assertThat(cache.get(2), is(-1));
        assertThat(cache.get(1), is(-1));
    }
}