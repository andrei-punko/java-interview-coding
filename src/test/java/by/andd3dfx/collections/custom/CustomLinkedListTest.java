package by.andd3dfx.collections.custom;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CustomLinkedListTest {

    @Test
    public void addNGet() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        assertThat(linkedList.size()).isEqualTo(0);
        assertTrue(linkedList.isEmpty());

        linkedList.add(3);
        linkedList.add(7);

        assertThat(linkedList.size()).isEqualTo(2);
        assertFalse(linkedList.isEmpty());
        assertThat(linkedList.get(0)).isEqualTo(3);
        assertThat(linkedList.get(1)).isEqualTo(7);

        linkedList.add(12);
        linkedList.add(34);

        assertThat(linkedList.size()).isEqualTo(4);
        assertFalse(linkedList.isEmpty());
        assertThat(linkedList.get(0)).isEqualTo(3);
        assertThat(linkedList.get(1)).isEqualTo(7);
        assertThat(linkedList.get(2)).isEqualTo(12);
        assertThat(linkedList.get(3)).isEqualTo(34);
    }

    @Test
    public void addNSetNGet() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        assertThat(linkedList.size()).isEqualTo(0);
        assertTrue(linkedList.isEmpty());
        linkedList.add(4);
        linkedList.add(5);
        linkedList.set(1, 56);
        linkedList.add(12);
        linkedList.set(0, 31);

        assertThat(linkedList.size()).isEqualTo(3);
        assertFalse(linkedList.isEmpty());
        assertThat(linkedList.get(0)).isEqualTo(31);
        assertThat(linkedList.get(1)).isEqualTo(56);
        assertThat(linkedList.get(2)).isEqualTo(12);
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

        assertThat(linkedList.size()).isEqualTo(6);
        assertThat(linkedList.get(0)).isEqualTo(3);
        assertThat(linkedList.get(1)).isEqualTo(34);
        assertThat(linkedList.get(2)).isEqualTo(7);
        assertThat(linkedList.get(3)).isEqualTo(67);
        assertThat(linkedList.get(4)).isEqualTo(12);
        assertThat(linkedList.get(5)).isEqualTo(102);
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

        assertThat(linkedList.size()).isEqualTo(4);
        assertThat(linkedList.get(0)).isEqualTo(3);
        assertThat(linkedList.get(1)).isEqualTo(7);
        assertThat(linkedList.get(2)).isEqualTo(12);
        assertThat(linkedList.get(3)).isEqualTo(34);

        linkedList.reverse();

        assertThat(linkedList.size()).isEqualTo(4);
        assertThat(linkedList.get(0)).isEqualTo(34);
        assertThat(linkedList.get(1)).isEqualTo(12);
        assertThat(linkedList.get(2)).isEqualTo(7);
        assertThat(linkedList.get(3)).isEqualTo(3);
    }

    @Test
    public void remove() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(11);
        linkedList.add(7);
        linkedList.add(12);
        linkedList.add(34);

        var removed = linkedList.remove();

        assertThat(removed).isEqualTo(11);
        assertThat(linkedList.size()).isEqualTo(3);
        assertThat(linkedList.get(0)).isEqualTo(7);
        assertThat(linkedList.get(1)).isEqualTo(12);
        assertThat(linkedList.get(2)).isEqualTo(34);

        var removed2 = linkedList.remove();

        assertThat(removed2).isEqualTo(7);
        assertThat(linkedList.size()).isEqualTo(2);
        assertThat(linkedList.get(0)).isEqualTo(12);
        assertThat(linkedList.get(1)).isEqualTo(34);
    }

    @Test
    public void removeByIndex() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(11);
        linkedList.add(7);
        linkedList.add(12);
        linkedList.add(34);

        var removed = linkedList.remove(2);

        assertThat(removed).isEqualTo(12);
        assertThat(linkedList.size()).isEqualTo(3);
        assertThat(linkedList.get(0)).isEqualTo(11);
        assertThat(linkedList.get(1)).isEqualTo(7);
        assertThat(linkedList.get(2)).isEqualTo(34);

        var removed2 = linkedList.remove(2);

        assertThat(removed2).isEqualTo(34);
        assertThat(linkedList.size()).isEqualTo(2);
        assertThat(linkedList.get(0)).isEqualTo(11);
        assertThat(linkedList.get(1)).isEqualTo(7);
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
        assertThat(linkedList.size()).isEqualTo(5);
        assertThat(linkedList.get(0)).isEqualTo("Andrei");
        assertThat(linkedList.get(1)).isEqualTo("Tikhon");
        assertThat(linkedList.get(2)).isEqualTo("Elena");
        assertThat(linkedList.get(3)).isEqualTo("Ilya");      // Only first 'Ilya' occurrence should be removed
        assertThat(linkedList.get(4)).isEqualTo("Yulia");
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
        assertThat(linkedList.size()).isEqualTo(4);
        assertThat(linkedList.get(0)).isEqualTo("Andrei");
        assertThat(linkedList.get(1)).isEqualTo("Tikhon");
        assertThat(linkedList.get(2)).isNull();         // Only first null occurrence should be removed
        assertThat(linkedList.get(3)).isEqualTo("Elena");
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
        assertThat(linkedList.size()).isEqualTo(5);
        assertThat(linkedList.get(0)).isEqualTo("Andrei");
        assertThat(linkedList.get(1)).isEqualTo("Tikhon");
        assertThat(linkedList.get(2)).isEqualTo("Ilya");
        assertThat(linkedList.get(3)).isEqualTo("Elena");
        assertThat(linkedList.get(4)).isEqualTo("Yulia");
    }

    @Test
    public void pushNPop() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        assertTrue(linkedList.isEmpty());
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(36);
        linkedList.push(39);

        assertThat(linkedList.pop()).isEqualTo(39);
        assertThat(linkedList.pop()).isEqualTo(36);
        assertThat(linkedList.pop()).isEqualTo(3);
        assertFalse(linkedList.isEmpty());
        assertThat(linkedList.pop()).isEqualTo(2);
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void pushNPopNRemove() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(36);    // 36 3 2
        assertThat(linkedList.remove(1)).isEqualTo(3);   // 36 2
        linkedList.push(39);
        linkedList.push(43);
        linkedList.push(45);    // 45 43 39 36 2
        assertThat(linkedList.remove(2)).isEqualTo(39);   // 45 43 36 2

        assertThat(linkedList.pop()).isEqualTo(45);
        assertThat(linkedList.pop()).isEqualTo(43);
        assertThat(linkedList.pop()).isEqualTo(36);
        assertThat(linkedList.pop()).isEqualTo(2);
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void clear() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(36);

        assertFalse(linkedList.isEmpty());
        assertThat(linkedList.size()).isEqualTo(3);

        linkedList.clear();

        assertTrue(linkedList.isEmpty());
        assertThat(linkedList.size()).isEqualTo(0);
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
        assertThat(result).isEqualTo(List.of(3, 7, 12));
    }

    @Test
    public void testForEachForEmptyList() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();

        var result = new ArrayList<>();
        for (var item : linkedList) {
            result.add(item);
        }
        assertThat(result).isEqualTo(List.of());
    }

    @Test
    public void testToString() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(3);
        linkedList.add(7);
        linkedList.add(12);
        linkedList.add(34);

        var result = linkedList.toString();

        assertThat(result).isEqualTo("CustomLinkedList{head={3, next={7, next={12, next={34}}}}}");
    }
}
