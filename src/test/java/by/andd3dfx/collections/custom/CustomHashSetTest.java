package by.andd3dfx.collections.custom;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CustomHashSetTest {

    @Test
    public void size() {
        CustomHashSet<String> set = new CustomHashSet<>();
        assertThat(set.size()).isEqualTo(0);

        set.add("One");
        assertThat(set.size()).isEqualTo(1);

        set.add("Two");
        assertThat(set.size()).isEqualTo(2);

        set.add("Two");
        assertThat(set.size()).isEqualTo(2);

        set.add("Three");
        assertThat(set.size()).isEqualTo(3);

        set.add("One");
        assertThat(set.size()).isEqualTo(3);
    }

    @Test
    public void isEmpty() {
        CustomHashSet<String> set = new CustomHashSet<>();
        assertTrue(set.isEmpty());
        set.add("One");
        assertFalse(set.isEmpty());
        set.add("Two");
        assertFalse(set.isEmpty());
    }

    @Test
    public void addNContains() {
        CustomHashSet<String> set = new CustomHashSet<>();
        assertFalse(set.contains("One"));
        assertFalse(set.contains("Two"));

        assertTrue(set.add("One"));
        assertTrue(set.add("Two"));
        assertFalse(set.add("Two"));

        assertTrue(set.contains("One"));
        assertTrue(set.contains("Two"));
        assertFalse(set.contains("Three"));
    }

    @Test
    public void addAllNContainsAll() {
        CustomHashSet<String> set = new CustomHashSet<>();
        set.addAll(List.of("One", "Two"));
        assertTrue(set.containsAll(List.of("One")));
        assertTrue(set.containsAll(List.of("Two", "One")));
        assertFalse(set.containsAll(List.of("Two", "One", "Three")));

        set.addAll(List.of("Three", "Four"));
        assertTrue(set.containsAll(List.of("Two", "One", "Three")));
    }

    @Test
    public void remove() {
        CustomHashSet<String> set = new CustomHashSet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");
        assertThat(set.size()).isEqualTo(3);

        assertTrue(set.remove("Two"));
        assertFalse(set.remove("Two"));
        assertThat(set.size()).isEqualTo(2);

        assertFalse(set.remove("Four"));
        assertThat(set.size()).isEqualTo(2);

        set.add("Two");
        assertTrue(set.remove("Two"));
        assertFalse(set.remove("Two"));
        assertThat(set.size()).isEqualTo(2);

        assertTrue(set.remove("One"));
        assertThat(set.size()).isEqualTo(1);
    }

    @Test
    public void removeAll() {
        CustomHashSet<String> set = new CustomHashSet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");
        assertThat(set.size()).isEqualTo(3);

        assertFalse(set.removeAll(List.of("Four", "Five")));
        assertThat(set.size()).isEqualTo(3);

        assertTrue(set.removeAll(List.of("One", "Three")));
        assertThat(set.size()).isEqualTo(1);
    }

    @Test
    public void clear() {
        CustomHashSet<String> set = new CustomHashSet<>();
        set.add("One");
        set.add("Two");
        assertThat(set.size()).isEqualTo(2);

        set.clear();

        assertThat(set.size()).isEqualTo(0);
        assertTrue(set.isEmpty());
        assertFalse(set.contains("One"));
        assertFalse(set.contains("Two"));
    }

    @Test
    public void forEach() {
        CustomHashSet<String> set = new CustomHashSet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Three");
        set.add("Four");
        set.add("Five");
        set.remove("Two");

        var etalonList = List.of("One", "Three", "Four", "Five");
        assertThat(set.size()).isEqualTo(etalonList.size());

        for (var item : set) {
            assertTrue(etalonList.contains(item));
        }
    }

    @Test
    public void forEachForEmpty() {
        CustomHashSet<String> set = new CustomHashSet<>();
        set.add("One");
        set.remove("One");

        for (var item : set) {
            fail("Iteration should not happen!");
        }
    }

    @Test
    public void testToString() {
        CustomHashSet<String> set = new CustomHashSet<>();
        set.add("Andrei");
        set.add("Tikhon");
        set.add("Yulia");
        set.add("Elena");

        assertThat(set.toString()).isEqualTo("[Elena, Yulia, Andrei, Tikhon]");
    }
}
