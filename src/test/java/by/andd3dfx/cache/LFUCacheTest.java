package by.andd3dfx.cache;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LFUCacheTest {

    @Test
    public void testCache() {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        assertThat(cache.get(1), is(1));
        cache.put(3, 3);    // evicts key 2
        assertThat(cache.get(2), is(-1));
        assertThat(cache.get(3), is(3));
        cache.put(4, 4);    // evicts key 1
        assertThat(cache.get(1), is(-1));
        assertThat(cache.get(3), is(3));
        assertThat(cache.get(4), is(4));
    }

    @Test
    public void testCache2() {
        LFUCache cache = new LFUCache(2);

        cache.put(2, 1);
        cache.put(3, 2);
        assertThat(cache.get(3), is(2));
        assertThat(cache.get(2), is(1));
        cache.put(4, 3);
        assertThat(cache.get(2), is(1));
        assertThat(cache.get(3), is(-1));
        assertThat(cache.get(4), is(3));
    }

    @Test
    public void testCacheForZeroCapacity() {
        LFUCache cache = new LFUCache(0);
        assertThat(cache.get(2), is(-1));
        cache.put(2, 1);
        assertThat(cache.get(2), is(-1));
    }
}
