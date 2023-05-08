package by.andd3dfx.collections.custom;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomHashMapTest {

    private CustomHashMap map;

    @Before
    public void setUp() throws Exception {
        map = new CustomHashMap();
    }

    @Test
    public void size() {
        assertThat(map.size(), is(0));
        map.put(2, 5);
        map.put(7, 45);
        assertThat(map.size(), is(2));
        map.put(7, 46);
        assertThat(map.size(), is(2));
    }

    @Test
    public void isEmpty() {
        assertThat(map.isEmpty(), is(true));
        map.put(2, 5);
        assertThat(map.isEmpty(), is(false));
    }

    @Test
    public void containsKey() {
        assertThat(map.containsKey(2), is(false));
        map.put(2, 5);
        map.put(7, 45);
        assertThat(map.containsKey(2), is(true));
        assertThat(map.containsKey(5), is(false));
        assertThat(map.containsKey(7), is(true));
    }

    @Test
    public void containsValue() {
        assertThat(map.containsValue(5), is(false));
        map.put(2, 5);
        map.put(7, 45);
        assertThat(map.containsValue(5), is(true));
        assertThat(map.containsValue(51), is(false));
        assertThat(map.containsValue(45), is(true));
    }

    @Test
    public void getAndPut() {
        assertThat(map.put(2, 5), is(5));
        assertThat(map.put(7, 45), is(45));
        assertThat(map.get(2), is(5));
        assertThat(map.get(7), is(45));
    }

    @Test
    public void getAndPutForNull() {
        assertThat(map.put(2, 5), is(5));
        assertThat(map.put(null, 45), is(45));
        assertThat(map.put(7, 89), is(89));
        assertThat(map.get(2), is(5));
        assertThat(map.get(null), is(45));
        assertThat(map.get(7), is(89));
    }

    @Ignore
    @Test
    public void remove() {
        map.put(2, 5);
        map.put(7, 45);
        map.put(9, 78);
        assertThat(map.get(2), is(5));
        assertThat(map.get(7), is(45));
        assertThat(map.get(9), is(78));

        assertThat(map.remove(7), is(45));

        assertThat(map.get(2), is(5));
        assertThat(map.get(7), nullValue());
        assertThat(map.get(9), is(78));

        assertThat(map.remove(9), is(78));

        assertThat(map.get(2), is(5));
        assertThat(map.get(7), nullValue());
        assertThat(map.get(9), nullValue());
    }

    @Test
    public void putAll() {
        map.put(2, 5);
        map.put(7, 45);
        map.put(9, 78);

        Map additionalMap = new CustomHashMap();
        additionalMap.put(2, 555);
        additionalMap.put(71, 22);
        additionalMap.put(23, 24);

        map.putAll(additionalMap);

        assertThat(map.get(2), is(555));
        assertThat(map.get(7), is(45));
        assertThat(map.get(9), is(78));
        assertThat(map.get(71), is(22));
        assertThat(map.get(23), is(24));
    }

    @Test
    public void clear() {
        map.put(2, 5);
        map.put(7, 45);
        map.put(null, 90);
        assertThat(map.get(2), is(5));
        assertThat(map.get(7), is(45));
        assertThat(map.containsKey(2), is(true));
        assertThat(map.containsKey(7), is(true));
        assertThat(map.get(null), is(90));

        map.clear();

        assertThat(map.get(2), nullValue());
        assertThat(map.get(7), nullValue());
        assertThat(map.containsKey(2), is(false));
        assertThat(map.containsKey(7), is(false));
        assertThat(map.get(null), nullValue());
    }

    @Test
    public void keySet() {
        map.put(2, 5);
        map.put(7, 45);
        map.put(9, 78);

        assertThat(map.keySet(), is(Set.of(2, 7, 9)));
    }

    @Test
    public void values() {
        map.put(2, 5);
        map.put(7, 45);
        map.put(9, 78);

        assertThat(map.values(), is(Set.of(5, 45, 78)));
    }

    @Test
    public void entrySet() {
        map.put(2, 5);
        map.put(7, 45);
        map.put(9, 78);

        assertThat(map.entrySet(), is(Set.of(
                new CustomEntry(2, 5),
                new CustomEntry(7, 45),
                new CustomEntry(9, 78)
        )));
    }

    @Test
    public void isEquals() {
        assertTrue(map.isEquals(null, null));
        assertFalse(map.isEquals(null, new CustomHashMap<>()));
        assertFalse(map.isEquals(new CustomHashMap<>(), null));

        var map1 = new CustomHashMap<>();
        assertTrue(map.isEquals(map1, map1));

        var map2 = new CustomHashMap<>();
        assertFalse(map.isEquals(map1, map2));
        assertFalse(map.isEquals(map2, map1));
    }
}
