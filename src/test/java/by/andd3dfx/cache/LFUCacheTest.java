package by.andd3dfx.cache;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class LFUCacheTest {

    @Test
    public void testCacheWithCapacity2() {
        LFUCache<Integer, Integer> cache = new LFUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);
        assertThat(cache.get(1), is(10));

        cache.put(3, 30);    // evicts key 2

        assertThat(cache.get(2), nullValue());
        assertThat(cache.get(3), is(30));

        cache.put(4, 40);    // evicts key 1

        assertThat(cache.get(1), nullValue());
        assertThat(cache.get(3), is(30));
        assertThat(cache.get(4), is(40));
    }

    @Test
    public void testCacheWithCapacity3() {
        LFUCache<Integer, Integer> cache = new LFUCache(3);

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        assertThat(cache.get(1), is(10));
        assertThat(cache.get(3), is(30));
        assertThat(cache.get(1), is(10));
        assertThat(cache.get(1), is(10));
        assertThat(cache.get(3), is(30));
        assertThat(cache.get(2), is(20));

        cache.put(4, 40);    // evicts key 2

        assertThat(cache.get(1), is(10));
        assertThat(cache.get(2), nullValue());
        assertThat(cache.get(3), is(30));
        assertThat(cache.get(4), is(40));
        assertThat(cache.get(4), is(40));

        cache.put(5, 50);    // evicts key 4

        assertThat(cache.get(1), is(10));
        assertThat(cache.get(2), nullValue());
        assertThat(cache.get(3), is(30));
        assertThat(cache.get(4), nullValue());
        assertThat(cache.get(5), is(50));
    }

    @Test
    public void testCacheForZeroCapacity() {
        LFUCache<Integer, Integer> cache = new LFUCache(0);

        assertThat(cache.get(2), nullValue());
        cache.put(2, 1);
        assertThat(cache.get(2), nullValue());
    }
}
