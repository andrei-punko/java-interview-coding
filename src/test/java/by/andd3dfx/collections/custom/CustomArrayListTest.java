package by.andd3dfx.collections.custom;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CustomArrayListTest {

    @Test
    public void addNGet() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        assertThat(list.size(), is(0));
        assertTrue(list.isEmpty());
        list.add(4);
        list.add(5);
        list.add(12);

        assertThat(list.size(), is(3));
        assertFalse(list.isEmpty());
        assertThat(list.get(0), is(4));
        assertThat(list.get(1), is(5));
        assertThat(list.get(2), is(12));
    }

    @Test
    public void addByIndex() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(3);
        list.add(7);
        list.add(12);                 // 3 7 12
        list.add(2, 67);  // 3 7 67 12
        list.add(1, 34);  // 3 34 7 67 12
        list.add(5, 102);  // 3 34 7 67 12 102 - addition of new element at the right should pass

        assertThat(list.size(), is(6));
        assertThat(list.get(0), is(3));
        assertThat(list.get(1), is(34));
        assertThat(list.get(2), is(7));
        assertThat(list.get(3), is(67));
        assertThat(list.get(4), is(12));
        assertThat(list.get(5), is(102));
    }

    @Test
    public void addNGetWhenArrayResizeExpected() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i * i);
        }

        assertThat(list.size(), is(20));
        assertFalse(list.isEmpty());
        for (int i = 0; i < 20; i++) {
            assertThat(list.get(i), is(i * i));
        }
    }

    @Test
    public void addIntoMiddleOfListNGetWhenArrayResizeExpected() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i * i);
        }
        for (int i = 0; i < 10; i++) {
            list.add(i + 5, i * i);
        }

        assertThat(list.size(), is(20));
        assertFalse(list.isEmpty());
        for (int i = 0; i < 5; i++) {
            assertThat(list.get(i), is(i * i));
        }
        for (int i = 0; i < 10; i++) {
            assertThat(list.get(i + 5), is(i * i));
        }
        for (int i = 5; i < 10; i++) {
            assertThat(list.get(i + 10), is(i * i));
        }
    }

    @Test
    public void addNSetNGet() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        assertThat(list.size(), is(0));
        assertTrue(list.isEmpty());
        list.add(4);
        list.add(5);
        list.set(1, 56);
        list.add(12);
        list.set(0, 31);

        assertThat(list.size(), is(3));
        assertFalse(list.isEmpty());
        assertThat(list.get(0), is(31));
        assertThat(list.get(1), is(56));
        assertThat(list.get(2), is(12));
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

        assertThat(removed, is(12));
        assertThat(list.size(), is(3));
        assertThat(list.get(0), is(11));
        assertThat(list.get(1), is(7));
        assertThat(list.get(2), is(34));

        var removed2 = list.remove(2);

        assertThat(removed2, is(34));
        assertThat(list.size(), is(2));
        assertThat(list.get(0), is(11));
        assertThat(list.get(1), is(7));
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
        list.add("Yulia");

        var removeResult = list.remove("Ilya");

        assertTrue(removeResult);
        assertThat(list.size(), is(4));
        assertThat(list.get(0), is("Andrei"));
        assertThat(list.get(1), is("Tikhon"));
        assertThat(list.get(2), is("Elena"));
        assertThat(list.get(3), is("Yulia"));

        var removeResult2 = list.remove("John");

        assertFalse(removeResult2);
        assertThat(list.size(), is(4));
        assertThat(list.get(0), is("Andrei"));
        assertThat(list.get(1), is("Tikhon"));
        assertThat(list.get(2), is("Elena"));
        assertThat(list.get(3), is("Yulia"));
    }

    @Test
    public void removeByValueWhenAbsent() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");
        list.add("Elena");
        list.add("Yulia");

        var removed = list.remove("Oksana");

        assertFalse(removed);
        assertThat(list.size(), is(5));
        assertThat(list.get(0), is("Andrei"));
        assertThat(list.get(1), is("Tikhon"));
        assertThat(list.get(2), is("Ilya"));
        assertThat(list.get(3), is("Elena"));
        assertThat(list.get(4), is("Yulia"));
    }

    @Test
    public void clear() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(2);
        list.add(3);
        list.add(36);

        assertFalse(list.isEmpty());
        assertThat(list.size(), is(3));

        list.clear();

        assertTrue(list.isEmpty());
        assertThat(list.size(), is(0));
    }

    @Test
    public void testToString() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Andrei");
        list.add("Tikhon");
        list.add("Ilya");

        assertThat(list.toString(), is("[Andrei, Tikhon, Ilya]"));
    }
}
