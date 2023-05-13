package by.andd3dfx.collections.custom;

import lombok.AllArgsConstructor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomHashMapTest {

    @Test
    public void size() {
        var map = new CustomHashMap();
        assertThat(map.size(), is(0));
        map.put(2, 5);
        assertThat(map.size(), is(1));
        map.put(7, 45);
        assertThat(map.size(), is(2));
        map.put(7, 46);
        assertThat(map.size(), is(2));
    }

    @Test
    public void isEmpty() {
        var map = new CustomHashMap();
        assertTrue(map.isEmpty());
        map.put(2, 5);
        assertFalse(map.isEmpty());
    }

    @Test
    public void containsKey() {
        var map = new CustomHashMap();
        assertFalse(map.containsKey(2));
        map.put(2, 5);
        map.put(7, 45);
        assertTrue(map.containsKey(2));
        assertFalse(map.containsKey(5));
        assertTrue(map.containsKey(7));
    }

    @Test
    public void containsValue() {
        var map = new CustomHashMap();
        assertFalse(map.containsValue(5));
        map.put(2, 5);
        map.put(7, 45);
        assertTrue(map.containsValue(5));
        assertFalse(map.containsValue(51));
        assertTrue(map.containsValue(45));
    }

    @Test
    public void getAndPut() {
        var map = new CustomHashMap();
        assertThat(map.put(2, 5), is(5));
        assertThat(map.put(7, 45), is(45));

        assertThat(map.get(2), is(5));
        assertThat(map.get(7), is(45));
        assertThat(map.get(156), is(nullValue()));
    }

    @Test
    public void getAndPutWhenHashCollided() {
        CustomHashMap<MyObject, Integer> map = new CustomHashMap<>();

        MyObject key1 = new MyObject(12);
        assertThat(map.put(key1, 5), is(5));

        MyObject key2 = new MyObject(13);
        assertThat(map.put(key2, 45), is(45));

        assertThat(map.get(key1), is(5));
        assertThat(map.get(key2), is(45));
        assertThat(map.get(new MyObject(156)), is(nullValue()));
    }

    @AllArgsConstructor
    private class MyObject {
        private int value;

        @Override
        public int hashCode() {
            return 34;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            return value == ((MyObject) o).value;
        }
    }

    @Test
    public void getAndPutForNull() {
        var map = new CustomHashMap();
        assertThat(map.put(2, 5), is(5));
        assertThat(map.put(null, 45), is(45));
        assertThat(map.put(7, 89), is(89));

        assertThat(map.get(2), is(5));
        assertThat(map.get(null), is(45));
        assertThat(map.get(7), is(89));
        assertThat(map.get(156), is(nullValue()));
    }

    @Test
    public void remove() {
        var map = new CustomHashMap();
        map.put(2, 5);
        map.put(7, 45);
        map.put(9, 78);
        assertThat(map.get(2), is(5));
        assertThat(map.get(7), is(45));
        assertThat(map.get(9), is(78));

        assertThat(map.remove(7), is(45));

        assertThat(map.size(), is(2));
        assertThat(map.get(2), is(5));
        assertThat(map.get(7), nullValue());
        assertThat(map.get(9), is(78));

        assertThat(map.remove(9), is(78));
        assertThat(map.remove(9), is(nullValue()));

        assertThat(map.size(), is(1));
        assertThat(map.get(2), is(5));
        assertThat(map.get(7), nullValue());
        assertThat(map.get(9), nullValue());
    }

    @Test
    public void removeForNull() {
        var map = new CustomHashMap();
        map.put(2, 5);
        map.put(null, 45);

        assertThat(map.get(2), is(5));
        assertThat(map.get(null), is(45));
        assertTrue(map.containsKey(2));
        assertTrue(map.containsKey(null));

        assertThat(map.remove(null), is(45));
        assertThat(map.remove(null), is(nullValue()));
        assertFalse(map.containsKey(null));
    }

    @Test
    public void clear() {
        var map = new CustomHashMap();
        map.put(2, 5);
        map.put(7, 45);
        map.put(null, 90);
        assertThat(map.get(2), is(5));
        assertThat(map.get(7), is(45));
        assertThat(map.get(null), is(90));

        map.clear();

        assertThat(map.get(2), nullValue());
        assertThat(map.get(7), nullValue());
        assertThat(map.get(null), nullValue());

        assertFalse(map.containsKey(2));
        assertFalse(map.containsKey(7));
        assertFalse(map.containsKey(null));

        assertFalse(map.containsValue(5));
        assertFalse(map.containsValue(45));
        assertFalse(map.containsValue(90));
    }

    @Test
    public void testToString() {
        var map = new CustomHashMap();
        map.put(2, 5);
        map.put(7, 45);

        assertThat(map.toString(), is("{2->5, 7->45}"));
    }
}
