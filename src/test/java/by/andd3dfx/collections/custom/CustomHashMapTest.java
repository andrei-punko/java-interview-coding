package by.andd3dfx.collections.custom;

import lombok.AllArgsConstructor;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CustomHashMapTest {

    @Test
    public void size() {
        var map = new CustomHashMap<>();
        assertThat(map.size()).isEqualTo(0);
        map.put(2, 5);
        assertThat(map.size()).isEqualTo(1);
        map.put(7, 45);
        assertThat(map.size()).isEqualTo(2);
        map.put(7, 46);
        assertThat(map.size()).isEqualTo(2);
    }

    @Test
    public void isEmpty() {
        var map = new CustomHashMap<>();
        assertTrue(map.isEmpty());
        map.put(2, 5);
        assertFalse(map.isEmpty());
    }

    @Test
    public void containsKey() {
        var map = new CustomHashMap<>();
        assertFalse(map.containsKey(2));
        map.put(2, 5);
        map.put(7, 45);
        assertTrue(map.containsKey(2));
        assertFalse(map.containsKey(5));
        assertTrue(map.containsKey(7));
    }

    @Test
    public void containsValue() {
        var map = new CustomHashMap<>();
        assertFalse(map.containsValue(5));
        map.put(2, 5);
        map.put(7, 45);
        assertTrue(map.containsValue(5));
        assertFalse(map.containsValue(51));
        assertTrue(map.containsValue(45));
    }

    @Test
    public void getAndPut() {
        var map = new CustomHashMap<>();
        assertThat(map.put(2, 5)).isNull();
        assertThat(map.put(7, 44)).isNull();
        assertThat(map.put(7, 45)).isEqualTo(44);

        assertThat(map.get(2)).isEqualTo(5);
        assertThat(map.get(7)).isEqualTo(45);
        assertThat(map.get(156)).isNull();
    }

    @Test
    public void getAndPutWhenHashCollided() {
        CustomHashMap<MyObject, Integer> map = new CustomHashMap<>();

        MyObject key1 = new MyObject(12);
        assertThat(map.put(key1, 5)).isNull();

        MyObject key2 = new MyObject(13);
        assertThat(map.put(key2, 45)).isNull();

        assertThat(map.get(key1)).isEqualTo(5);
        assertThat(map.get(key2)).isEqualTo(45);
        assertThat(map.get(new MyObject(156))).isNull();
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
        var map = new CustomHashMap<>();
        assertThat(map.put(2, 67)).isNull();
        assertThat(map.put(2, 5)).isEqualTo(67);
        assertThat(map.put(null, 45)).isNull();
        assertThat(map.put(7, 89)).isNull();

        assertThat(map.get(2)).isEqualTo(5);
        assertThat(map.get(null)).isEqualTo(45);
        assertThat(map.get(7)).isEqualTo(89);
        assertThat(map.get(156)).isNull();
    }

    @Test
    public void remove() {
        var map = new CustomHashMap<>();
        map.put(2, 5);
        map.put(7, 45);
        map.put(9, 78);
        assertThat(map.get(2)).isEqualTo(5);
        assertThat(map.get(7)).isEqualTo(45);
        assertThat(map.get(9)).isEqualTo(78);

        assertThat(map.remove(7)).isEqualTo(45);

        assertThat(map.size()).isEqualTo(2);
        assertThat(map.get(2)).isEqualTo(5);
        assertThat(map.get(7)).isNull();
        assertThat(map.get(9)).isEqualTo(78);

        assertThat(map.remove(9)).isEqualTo(78);
        assertThat(map.remove(9)).isNull();

        assertThat(map.size()).isEqualTo(1);
        assertThat(map.get(2)).isEqualTo(5);
        assertThat(map.get(7)).isNull();
        assertThat(map.get(9)).isNull();
    }

    @Test
    public void removeForNull() {
        var map = new CustomHashMap<>();
        map.put(2, 5);
        map.put(null, 45);

        assertThat(map.get(2)).isEqualTo(5);
        assertThat(map.get(null)).isEqualTo(45);
        assertTrue(map.containsKey(2));
        assertTrue(map.containsKey(null));

        assertThat(map.remove(null)).isEqualTo(45);
        assertThat(map.remove(null)).isNull();
        assertFalse(map.containsKey(null));
    }

    @Test
    public void clear() {
        var map = new CustomHashMap<>();
        map.put(2, 5);
        map.put(7, 45);
        map.put(null, 90);
        assertThat(map.get(2)).isEqualTo(5);
        assertThat(map.get(7)).isEqualTo(45);
        assertThat(map.get(null)).isEqualTo(90);

        map.clear();

        assertThat(map.get(2)).isNull();
        assertThat(map.get(7)).isNull();
        assertThat(map.get(null)).isNull();

        assertFalse(map.containsKey(2));
        assertFalse(map.containsKey(7));
        assertFalse(map.containsKey(null));

        assertFalse(map.containsValue(5));
        assertFalse(map.containsValue(45));
        assertFalse(map.containsValue(90));
    }

    @Test
    public void keySetForEmptyMap() {
        var map = new CustomHashMap<>();

        var result = map.keySet();

        assertThat(result.size()).isEqualTo(0);
        assertTrue(result.containsAll(List.of()));
    }

    @Test
    public void keySet() {
        var map = new CustomHashMap<>();
        map.put(2, 5);
        map.put(7, 45);
        map.put(9, 78);

        var result = map.keySet();

        assertThat(result.size()).isEqualTo(3);
        assertTrue(result.containsAll(List.of(2, 7, 9)));
    }

    @Test
    public void keyIterator() {
        var map = new CustomHashMap<Integer, Object>();
        map.put(2, 5);
        map.put(7, 45);
        map.put(9, 78);

        var index = 0;
        var expectedKeys = List.of(2, 7, 9);

        var keyIterator = map.keyIterator();
        while (keyIterator.hasNext()) {
            var item = keyIterator.next();
            assertThat(item).isEqualTo(expectedKeys.get(index));
            index++;
        }
        assertThrows(NoSuchElementException.class, () -> keyIterator.next());
    }

    @Test
    public void testToString() {
        var map = new CustomHashMap<>();
        map.put(2, 5);
        map.put(7, 45);

        assertThat(map.toString()).isEqualTo("{2->5, 7->45}");
    }
}
