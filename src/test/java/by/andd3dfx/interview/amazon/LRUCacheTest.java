package by.andd3dfx.interview.amazon;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void testCache() {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        assertThat("returns 1", cache.get(1), is(1));
        cache.put(3, 3);    // evicts key 2
        assertThat("returns -1 (not found)", cache.get(2), is(-1));
        cache.put(4, 4);    // evicts key 1
        assertThat("returns -1 (not found)", cache.get(1), is(-1));
        assertThat("returns 3", cache.get(3), is(3));
        assertThat("returns 4", cache.get(4), is(4));
    }

    @Test
    public void testCacheForZeroCapacity() {
        LRUCache cache = new LRUCache(0);
        assertThat("returns -1", cache.get(2), is(-1));
        cache.put(2, 1);
        assertThat("returns -1", cache.get(2), is(-1));
    }
}