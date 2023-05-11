package by.andd3dfx.collections.custom;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CustomLinkedListTest {

    @Test
    public void addNGet() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        assertThat(linkedList.size(), is(0));
        assertTrue(linkedList.isEmpty());

        linkedList.add(3);
        linkedList.add(7);

        assertThat(linkedList.size(), is(2));
        assertFalse(linkedList.isEmpty());
        assertThat(linkedList.get(0), is(3));
        assertThat(linkedList.get(1), is(7));

        linkedList.add(12);
        linkedList.add(34);

        assertThat(linkedList.size(), is(4));
        assertFalse(linkedList.isEmpty());
        assertThat(linkedList.get(0), is(3));
        assertThat(linkedList.get(1), is(7));
        assertThat(linkedList.get(2), is(12));
        assertThat(linkedList.get(3), is(34));
    }

    @Test
    public void addNSetNGet() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        assertThat(linkedList.size(), is(0));
        assertTrue(linkedList.isEmpty());
        linkedList.add(4);
        linkedList.add(5);
        linkedList.set(1, 56);
        linkedList.add(12);
        linkedList.set(0, 31);

        assertThat(linkedList.size(), is(3));
        assertFalse(linkedList.isEmpty());
        assertThat(linkedList.get(0), is(31));
        assertThat(linkedList.get(1), is(56));
        assertThat(linkedList.get(2), is(12));
    }

    @Test
    public void addByIndex() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(3);
        linkedList.add(7);
        linkedList.add(12);                 // 3 7 12
        linkedList.add(2, 67);  // 3 7 67 12
        linkedList.add(1, 34);  // 3 34 7 67 12
        linkedList.add(5, 102);  // 3 34 7 67 12 102 - addition of new element at the right should pass

        assertThat(linkedList.size(), is(6));
        assertThat(linkedList.get(0), is(3));
        assertThat(linkedList.get(1), is(34));
        assertThat(linkedList.get(2), is(7));
        assertThat(linkedList.get(3), is(67));
        assertThat(linkedList.get(4), is(12));
        assertThat(linkedList.get(5), is(102));
    }

    @Test
    public void addByIndexWhenOutOfRange() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(3);
        linkedList.add(7);
        linkedList.add(12);

        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(-1, 34));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(4, 34));
    }

    @Test
    public void setByIndexWhenOutOfRange() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(3);
        linkedList.add(7);
        linkedList.add(12);

        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(-1, 34));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(4, 34));
    }

    @Test
    public void getByIndexWhenOutOfRange() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(3);
        linkedList.add(7);
        linkedList.add(12);

        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(5));
    }

    @Test
    public void reverse() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(3);
        linkedList.add(7);
        linkedList.add(12);
        linkedList.add(34);

        assertThat(linkedList.size(), is(4));
        assertThat(linkedList.get(0), is(3));
        assertThat(linkedList.get(1), is(7));
        assertThat(linkedList.get(2), is(12));
        assertThat(linkedList.get(3), is(34));

        linkedList.reverse();

        assertThat(linkedList.size(), is(4));
        assertThat(linkedList.get(0), is(34));
        assertThat(linkedList.get(1), is(12));
        assertThat(linkedList.get(2), is(7));
        assertThat(linkedList.get(3), is(3));
    }

    @Test
    public void remove() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(11);
        linkedList.add(7);
        linkedList.add(12);
        linkedList.add(34);

        var removed = linkedList.remove();

        assertThat(removed, is(11));
        assertThat(linkedList.size(), is(3));
        assertThat(linkedList.get(0), is(7));
        assertThat(linkedList.get(1), is(12));
        assertThat(linkedList.get(2), is(34));

        var removed2 = linkedList.remove();

        assertThat(removed2, is(7));
        assertThat(linkedList.size(), is(2));
        assertThat(linkedList.get(0), is(12));
        assertThat(linkedList.get(1), is(34));
    }

    @Test
    public void removeByIndex() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(11);
        linkedList.add(7);
        linkedList.add(12);
        linkedList.add(34);

        var removed = linkedList.remove(2);

        assertThat(removed, is(12));
        assertThat(linkedList.size(), is(3));
        assertThat(linkedList.get(0), is(11));
        assertThat(linkedList.get(1), is(7));
        assertThat(linkedList.get(2), is(34));

        var removed2 = linkedList.remove(2);

        assertThat(removed2, is(34));
        assertThat(linkedList.size(), is(2));
        assertThat(linkedList.get(0), is(11));
        assertThat(linkedList.get(1), is(7));
    }

    @Test
    public void removeByIndexWhenOutOfRange() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(3);
        linkedList.add(7);
        linkedList.add(12);

        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(3));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(5));
    }

    @Test
    public void removeByValue() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        linkedList.add("Andrei");
        linkedList.add("Tikhon");
        linkedList.add("Ilya");
        linkedList.add("Elena");
        linkedList.add("Ilya");
        linkedList.add("Yulia");

        var removeResult = linkedList.remove("Ilya");

        assertTrue(removeResult);
        assertThat(linkedList.size(), is(5));
        assertThat(linkedList.get(0), is("Andrei"));
        assertThat(linkedList.get(1), is("Tikhon"));
        assertThat(linkedList.get(2), is("Elena"));
        assertThat(linkedList.get(3), is("Ilya"));      // Only first 'Ilya' occurrence should be removed
        assertThat(linkedList.get(4), is("Yulia"));
    }

    @Test
    public void removeByValueWhenNullsPresent() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        linkedList.add("Andrei");
        linkedList.add(null);
        linkedList.add("Tikhon");
        linkedList.add(null);
        linkedList.add("Elena");

        var removeResult = linkedList.remove(null);

        assertTrue(removeResult);
        assertThat(linkedList.size(), is(4));
        assertThat(linkedList.get(0), is("Andrei"));
        assertThat(linkedList.get(1), is("Tikhon"));
        assertThat(linkedList.get(2), is(nullValue()));     // Only first null occurrence should be removed
        assertThat(linkedList.get(3), is("Elena"));
    }

    @Test
    public void removeByValueWhenAbsent() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        linkedList.add("Andrei");
        linkedList.add("Tikhon");
        linkedList.add("Ilya");
        linkedList.add("Elena");
        linkedList.add("Yulia");

        var removeResult = linkedList.remove("Oksana");

        assertFalse(removeResult);
        assertThat(linkedList.size(), is(5));
        assertThat(linkedList.get(0), is("Andrei"));
        assertThat(linkedList.get(1), is("Tikhon"));
        assertThat(linkedList.get(2), is("Ilya"));
        assertThat(linkedList.get(3), is("Elena"));
        assertThat(linkedList.get(4), is("Yulia"));
    }

    @Test
    public void pushNPop() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        assertTrue(linkedList.isEmpty());
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(36);
        linkedList.push(39);

        assertThat(linkedList.pop(), is(39));
        assertThat(linkedList.pop(), is(36));
        assertThat(linkedList.pop(), is(3));
        assertFalse(linkedList.isEmpty());
        assertThat(linkedList.pop(), is(2));
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void pushNPopNRemove() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(36);    // 36 3 2
        assertThat(linkedList.remove(1), is(3));   // 36 2
        linkedList.push(39);
        linkedList.push(43);
        linkedList.push(45);    // 45 43 39 36 2
        assertThat(linkedList.remove(2), is(39));   // 45 43 36 2

        assertThat(linkedList.pop(), is(45));
        assertThat(linkedList.pop(), is(43));
        assertThat(linkedList.pop(), is(36));
        assertThat(linkedList.pop(), is(2));
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void clear() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(36);

        assertFalse(linkedList.isEmpty());
        assertThat(linkedList.size(), is(3));

        linkedList.clear();

        assertTrue(linkedList.isEmpty());
        assertThat(linkedList.size(), is(0));
    }

    @Test
    public void testForEach() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(3);
        linkedList.add(7);
        linkedList.add(12);

        var result = new ArrayList<>();
        for (var item : linkedList) {
            result.add(item);
        }
        assertThat(result, is(List.of(3, 7, 12)));
    }

    @Test
    public void testForEachForEmptyList() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();

        var result = new ArrayList<>();
        for (var item : linkedList) {
            result.add(item);
        }
        assertThat(result, is(List.of()));
    }

    @Test
    public void testToString() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(3);
        linkedList.add(7);
        linkedList.add(12);
        linkedList.add(34);

        var result = linkedList.toString();

        assertThat(result, is("CustomLinkedList{head={3, next={7, next={12, next={34}}}}}"));
    }
}
