package by.andd3dfx.collections.custom;

import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CustomArrayListTest {

    @Test
    public void addNGet() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        assertThat(list.size()).isEqualTo(0);
        assertTrue(list.isEmpty());
        list.add(4);
        list.add(5);
        list.add(12);

        assertThat(list.size()).isEqualTo(3);
        assertFalse(list.isEmpty());
        assertThat(list.get(0)).isEqualTo(4);
        assertThat(list.get(1)).isEqualTo(5);
        assertThat(list.get(2)).isEqualTo(12);
    }

    @Test
    public void addByIndexNGet() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
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
        CustomArrayList<Integer> list = new CustomArrayList<>();
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
        CustomArrayList<Integer> list = new CustomArrayList<>();
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
        CustomArrayList<Integer> list = new CustomArrayList<>();
        assertThat(list.size()).isEqualTo(0);
        assertTrue(list.isEmpty());
        list.add(4);
        list.add(5);
        list.set(1, 56);
        list.add(12);
        list.set(0, 31);

        assertThat(list.size()).isEqualTo(3);
        assertFalse(list.isEmpty());
        assertThat(list.get(0)).isEqualTo(31);
        assertThat(list.get(1)).isEqualTo(56);
        assertThat(list.get(2)).isEqualTo(12);
    }

    @Test
    public void addByIndexWhenOutOfRange() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(3);
        list.add(7);
        list.add(12);

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 34));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(4, 34));
    }

    @Test
    public void getByIndexWhenOutOfRange() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(3);
        list.add(7);
        list.add(12);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }

    @Test
    public void setByIndexWhenOutOfRange() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(3);
        list.add(7);
        list.add(12);

        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, 34));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(4, 34));
    }

    @Test
    public void removeByIndex() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
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
        CustomArrayList<Integer> list = new CustomArrayList<>();
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
    private static int determineInnerArrayLength(CustomArrayList list) {
        Field field = list.getClass().getDeclaredField("array");
        field.setAccessible(true);
        var length = ((Object[]) field.get(list)).length;
        return length;
    }

    @Test
    public void removeByIndexWhenOutOfRange() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(3);
        list.add(7);
        list.add(12);

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
    }

    @Test
    public void removeByValue() {
        CustomArrayList<String> list = new CustomArrayList<>();
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
        CustomArrayList<String> list = new CustomArrayList<>();
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
        CustomArrayList<String> list = new CustomArrayList<>();
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
        CustomArrayList<String> list = new CustomArrayList<>();
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
        CustomArrayList<Integer> list = new CustomArrayList<>();
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
        CustomArrayList<Integer> list = new CustomArrayList<>();
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
        CustomArrayList<Integer> list = new CustomArrayList<>();

        var result = new ArrayList<>();
        for (var item : list) {
            result.add(item);
        }
        assertThat(result).isEqualTo(List.of());
    }

    @Test
    public void testToString() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");

        assertThat(list.toString()).isEqualTo("[Andrei, Tikhon, Ilya]");
    }
}
