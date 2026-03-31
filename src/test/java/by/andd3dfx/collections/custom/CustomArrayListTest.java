package by.andd3dfx.collections.custom;

import lombok.SneakyThrows;
import org.apache.commons.lang3.NotImplementedException;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CustomArrayListTest {

    @Test
    public void addNGet() {
        List<Integer> list = new CustomArrayList<>();
        assertThat(list.size()).isEqualTo(0);
        assertTrue(list.isEmpty());
        assertTrue(list.add(4));
        assertTrue(list.add(5));
        assertTrue(list.add(12));

        assertThat(list.size()).isEqualTo(3);
        assertFalse(list.isEmpty());
        assertThat(list.get(0)).isEqualTo(4);
        assertThat(list.get(1)).isEqualTo(5);
        assertThat(list.get(2)).isEqualTo(12);
    }

    @Test
    public void addByIndexNGet() {
        List<Integer> list = new CustomArrayList<>();
        list.add(3);
        list.add(7);
        list.add(12);                 // 3 7 12
        list.add(2, 67);  // 3 7 67 12
        list.add(1, 34);  // 3 34 7 67 12
        list.add(5, 102);  // 3 34 7 67 12 102 - addition of a new element at the right should pass

        assertThat(list.size()).isEqualTo(6);
        assertThat(list.get(0)).isEqualTo(3);
        assertThat(list.get(1)).isEqualTo(34);
        assertThat(list.get(2)).isEqualTo(7);
        assertThat(list.get(3)).isEqualTo(67);
        assertThat(list.get(4)).isEqualTo(12);
        assertThat(list.get(5)).isEqualTo(102);
    }

    @Test
    public void addNGetWhenArrayUpResizeExpected() {
        List<Integer> list = new CustomArrayList<>();
        assertThat(determineInnerArrayLength(list)).isEqualTo(10);
        for (int i = 0; i < 20; i++) {
            list.add(i * i);
        }

        assertThat(list.size()).isEqualTo(20);
        assertFalse(list.isEmpty());
        assertThat(determineInnerArrayLength(list)).isGreaterThanOrEqualTo(20);
        for (int i = 0; i < 20; i++) {
            assertThat(list.get(i)).isEqualTo(i * i);
        }
    }

    @Test
    public void addIntoMiddleOfListNGetWhenArrayUpResizeExpected() {
        List<Integer> list = new CustomArrayList<>();
        assertThat(determineInnerArrayLength(list)).isEqualTo(10);
        for (int i = 0; i < 10; i++) {
            list.add(i * i);
        }
        for (int i = 0; i < 10; i++) {
            list.add(i + 5, i * i);
        }

        assertThat(list.size()).isEqualTo(20);
        assertFalse(list.isEmpty());
        assertThat(determineInnerArrayLength(list)).isGreaterThanOrEqualTo(20);
        for (int i = 0; i < 5; i++) {
            assertThat(list.get(i)).isEqualTo(i * i);
        }
        for (int i = 0; i < 10; i++) {
            assertThat(list.get(i + 5)).isEqualTo(i * i);
        }
        for (int i = 5; i < 10; i++) {
            assertThat(list.get(i + 10)).isEqualTo(i * i);
        }
    }

    @Test
    public void addNSetNGet() {
        List<Integer> list = new CustomArrayList<>();
        assertThat(list.size()).isEqualTo(0);
        assertTrue(list.isEmpty());
        list.add(4);
        list.add(5);
        assertThat(list.set(1, 56)).isEqualTo(56);
        list.add(12);
        assertThat(list.set(0, 31)).isEqualTo(31);

        assertThat(list.size()).isEqualTo(3);
        assertFalse(list.isEmpty());
        assertThat(list.get(0)).isEqualTo(31);
        assertThat(list.get(1)).isEqualTo(56);
        assertThat(list.get(2)).isEqualTo(12);
    }

    @Test
    public void addByIndexWhenOutOfRange() {
        List<Integer> list = new CustomArrayList<>();
        list.add(3);
        list.add(7);
        list.add(12);

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 34));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(4, 34));
    }

    @Test
    public void getByIndexWhenOutOfRange() {
        List<Integer> list = new CustomArrayList<>();
        list.add(3);
        list.add(7);
        list.add(12);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }

    @Test
    public void setByIndexWhenOutOfRange() {
        List<Integer> list = new CustomArrayList<>();
        list.add(3);
        list.add(7);
        list.add(12);

        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, 34));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(4, 34));
    }

    @Test
    public void removeByIndex() {
        List<Integer> list = new CustomArrayList<>();
        list.add(11);
        list.add(7);
        list.add(12);
        list.add(34);

        var removed = list.remove(2);

        assertThat(removed).isEqualTo(12);
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(11);
        assertThat(list.get(1)).isEqualTo(7);
        assertThat(list.get(2)).isEqualTo(34);

        var removed2 = list.remove(2);

        assertThat(removed2).isEqualTo(34);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0)).isEqualTo(11);
        assertThat(list.get(1)).isEqualTo(7);
    }

    @Test
    public void removeByIndexWhenArrayDecResizedExpected() {
        List<Integer> list = new CustomArrayList<>();
        assertThat(determineInnerArrayLength(list)).isEqualTo(10);
        for (int i = 0; i < 20; i++) {
            list.add(i * i);
        }
        assertThat(determineInnerArrayLength(list)).isGreaterThanOrEqualTo(20);

        for (int i = 0; i < 18; i++) {
            list.remove(1);     // Delete element at the start of inner array multiple times
        }

        assertThat(list.size()).isEqualTo(2);
        assertThat(determineInnerArrayLength(list)).isEqualTo(10);
    }

    @SneakyThrows
    private static int determineInnerArrayLength(List list) {
        Field field = list.getClass().getDeclaredField("array");
        field.setAccessible(true);
        var length = ((Object[]) field.get(list)).length;
        return length;
    }

    @Test
    public void removeByIndexWhenOutOfRange() {
        List<Integer> list = new CustomArrayList<>();
        list.add(3);
        list.add(7);
        list.add(12);

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
    }

    @Test
    public void removeByValue() {
        List<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");
        list.add("Elena");
        list.add("Ilya");
        list.add("Yulia");

        var removeResult = list.remove("Ilya");

        assertTrue(removeResult);
        assertThat(list.size()).isEqualTo(5);
        assertThat(list.get(0)).isEqualTo("Andrei");
        assertThat(list.get(1)).isEqualTo("Tikhon");
        assertThat(list.get(2)).isEqualTo("Elena");
        assertThat(list.get(3)).isEqualTo("Ilya");
        assertThat(list.get(4)).isEqualTo("Yulia");
    }

    @Test
    public void removeByValueWhenArrayDecResizedExpected() {
        List<String> list = new CustomArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(String.valueOf(i * i));
        }
        assertThat(determineInnerArrayLength(list)).isGreaterThanOrEqualTo(20);

        for (int i = 5; i < 20; i++) {
            assertTrue(list.remove(String.valueOf(i * i)));
        }

        assertThat(list.size()).isEqualTo(5);
        assertThat(determineInnerArrayLength(list)).isEqualTo(10);
    }

    @Test
    public void removeByValueWhenNullsPresent() {
        List<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add(null);
        list.add("Tikhon");
        list.add(null);
        list.add("Elena");

        var removeResult = list.remove(null);

        assertTrue(removeResult);
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(0)).isEqualTo("Andrei");
        assertThat(list.get(1)).isEqualTo("Tikhon");
        assertThat(list.get(2)).isNull();
        assertThat(list.get(3)).isEqualTo("Elena");
    }

    @Test
    public void removeByValueWhenAbsent() {
        List<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");
        list.add("Elena");
        list.add("Yulia");

        var removeResult = list.remove("Oksana");

        assertFalse(removeResult);
        assertThat(list.size()).isEqualTo(5);
        assertThat(list.get(0)).isEqualTo("Andrei");
        assertThat(list.get(1)).isEqualTo("Tikhon");
        assertThat(list.get(2)).isEqualTo("Ilya");
        assertThat(list.get(3)).isEqualTo("Elena");
        assertThat(list.get(4)).isEqualTo("Yulia");
    }

    @Test
    public void clear() {
        List<Integer> list = new CustomArrayList<>();
        list.add(2);
        list.add(3);
        list.add(36);

        assertFalse(list.isEmpty());
        assertThat(list.size()).isEqualTo(3);

        list.clear();

        assertTrue(list.isEmpty());
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void testForEach() {
        List<Integer> list = new CustomArrayList<>();
        list.add(3);
        list.add(7);
        list.add(12);

        var result = new ArrayList<>();
        for (var item : list) {
            result.add(item);
        }
        assertThat(result).isEqualTo(List.of(3, 7, 12));
    }

    @Test
    public void testForEachForEmptyList() {
        List<Integer> list = new CustomArrayList<>();

        var result = new ArrayList<>();
        for (var item : list) {
            result.add(item);
        }
        assertThat(result).isEqualTo(List.of());
    }

    @Test
    public void testToString() {
        List<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");

        assertThat(list.toString()).isEqualTo("[Andrei, Tikhon, Ilya]");
    }

    @Test
    public void testContains() {
        List<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");

        assertThat(list.contains("Tikhon")).isTrue();
        assertThat(list.contains("Andrei")).isTrue();
        assertThat(list.contains("Isaac")).isFalse();
    }

    @Test
    public void testContainsAll() {
        List<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");

        assertThat(list.containsAll(List.of())).isTrue();
        assertThat(list.containsAll(List.of("Ilya", "Tikhon"))).isTrue();
        assertThat(list.containsAll(List.of("Ilya", "Pavel"))).isFalse();
    }

    @Test
    public void testAddAll_NoResize() {
        var list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");

        list.addAll(List.of("Taisia", "Nika"));

        assertThat(list.size()).isEqualTo(5);
        assertThat(list.toString()).isEqualTo("[Andrei, Tikhon, Ilya, Taisia, Nika]");
    }

    @Test
    public void testAddAll_ResizeRequired() {
        var list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");

        list.addAll(List.of("Taisia", "Nika", "Taisia", "Nika", "Taisia", "Alexey", "Taisia", "Nika"));

        assertThat(list.size()).isEqualTo(11);
        assertThat(list.toString()).isEqualTo("[Andrei, Tikhon, Ilya, Taisia, Nika, Taisia, Nika, Taisia, Alexey, Taisia, Nika]");
    }

    @Test
    public void testRemoveAll() {
        List<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");

        list.removeAll(List.of("Nina", "Ilya"));

        assertThat(list.contains("Andrei")).isTrue();
        assertThat(list.contains("Tikhon")).isTrue();
        assertThat(list.contains("Ilya")).isFalse();
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void testRetainAll() {
        List<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");

        list.retainAll(List.of("Tikhon", "Nina", "Andrei"));

        assertThat(list.contains("Andrei")).isTrue();
        assertThat(list.contains("Tikhon")).isTrue();
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void testToArray() {
        List<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");

        Object[] result = list.toArray();

        assertThat(result[0]).isEqualTo("Andrei");
        assertThat(result[1]).isEqualTo("Tikhon");
        assertThat(result[2]).isEqualTo("Ilya");
    }

    @Test
    public void testToArrayTyped() {
        List<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");

        String[] result = list.toArray(new String[0]);

        assertThat(result[0]).isEqualTo("Andrei");
        assertThat(result[1]).isEqualTo("Tikhon");
        assertThat(result[2]).isEqualTo("Ilya");
    }

    @Test
    public void testToArrayTypedWhenLongArrayPassedAsParameter() {
        List<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");

        String[] result = list.toArray(new String[]{"a", "b", "c", "d"});

        assertThat(result[0]).isEqualTo("Andrei");
        assertThat(result[1]).isEqualTo("Tikhon");
        assertThat(result[2]).isEqualTo("Ilya");
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void indexOf() {
        List<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Nina");
        list.add(null);
        list.add("Ilya");
        list.add(null);

        assertThat(list.indexOf("Tikhon")).isEqualTo(1);
        assertThat(list.indexOf(null)).isEqualTo(3);
    }

    @Test
    public void lastIndexOf() {
        List<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Nina");
        list.add(null);
        list.add("Tikhon");
        list.add("Ilya");
        list.add(null);

        assertThat(list.lastIndexOf("Tikhon")).isEqualTo(4);
        assertThat(list.lastIndexOf(null)).isEqualTo(6);
    }

    @Test
    public void iterator() {
        var list = new CustomArrayList<String>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Nina");

        var iterator = list.iterator();
        var collectedItems = new ArrayList<String>();
        while (iterator.hasNext()) {
            collectedItems.add(iterator.next());
        }
        assertThat(collectedItems).isEqualTo(List.of("Andrei", "Tikhon", "Nina"));
    }

    @Test
    public void listIterator() {
        var list = new CustomArrayList<String>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Nina");

        var iterator = list.listIterator();
        var collectedItems = new ArrayList<String>();
        while (iterator.hasNext()) {
            collectedItems.add(iterator.next());
        }
        assertThat(collectedItems).isEqualTo(List.of("Andrei", "Tikhon", "Nina"));
    }

    @Test
    public void listIteratorComplex() {
        var list = new CustomArrayList<String>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Nina");

        var iterator = list.listIterator();
        var collectedItems = new ArrayList<String>();
        collectedItems.add(iterator.next());
        collectedItems.add(iterator.next());
        collectedItems.add(iterator.previous());
        collectedItems.add(iterator.previous());
        assertThat(iterator.hasPrevious()).isEqualTo(false);
        collectedItems.add(iterator.next());
        collectedItems.add(iterator.next());
        assertThat(iterator.hasNext()).isEqualTo(true);
        collectedItems.add(iterator.next());
        assertThat(iterator.hasNext()).isEqualTo(false);

        assertThat(collectedItems).isEqualTo(List.of("Andrei", "Tikhon", "Tikhon", "Andrei", "Andrei", "Tikhon", "Nina"));
    }

    @Test
    public void listIteratorWithIndex() {
        var list = new CustomArrayList<String>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Nina");

        var iterator = list.listIterator(1);
        var collectedItems = new ArrayList<String>();
        collectedItems.add(iterator.next());
        assertThat(iterator.hasNext()).isEqualTo(true);
        collectedItems.add(iterator.next());
        assertThat(iterator.hasNext()).isEqualTo(false);
        assertThrows(NoSuchElementException.class, iterator::next);
        collectedItems.add(iterator.previous());
        assertThat(iterator.hasPrevious()).isEqualTo(true);
        collectedItems.add(iterator.previous());
        assertThat(iterator.hasPrevious()).isEqualTo(true);
        collectedItems.add(iterator.previous());
        assertThat(iterator.hasPrevious()).isEqualTo(false);
        assertThrows(NoSuchElementException.class, iterator::previous);

        assertThat(collectedItems).isEqualTo(List.of("Tikhon", "Nina", "Nina", "Tikhon", "Andrei"));
    }

    @Test
    public void subList() {
        var list = new CustomArrayList<>();

        assertThrows(NotImplementedException.class, () -> list.subList(1, 3));
    }

    @Test
    public void testAddAllWithIndex_NoResize() {
        var list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");

        list.addAll(1, List.of("Taisia", "Nika"));

        assertThat(list.size()).isEqualTo(5);
        assertThat(list.toString()).isEqualTo("[Andrei, Taisia, Nika, Tikhon, Ilya]");
    }

    @Test
    public void testAddAllWithIndex_ResizeRequired() {
        var list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");

        list.addAll(1, List.of("Taisia", "Nika", "Taisia", "Nika", "Taisia", "Alexey", "Taisia", "Nika"));

        assertThat(list.size()).isEqualTo(11);
        assertThat(list.toString()).isEqualTo("[Andrei, Taisia, Nika, Taisia, Nika, Taisia, Alexey, Taisia, Nika, Tikhon, Ilya]");
    }
}
