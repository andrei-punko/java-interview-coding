package by.andd3dfx.iterators;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CompositeIteratorTest {

    @Test
    public void testNextAndHasNext() {
        List<Integer> list1 = Arrays.asList(12, 52);
        List<Integer> list2 = Arrays.asList(34, 98, 2);
        var compositeIterator = new CompositeIterator<>(list1.iterator(), list2.iterator());

        var result = new ArrayList<>();
        while (compositeIterator.hasNext()) {
            Integer item = compositeIterator.next();
            result.add(item);
        }

        assertThat(result).isEqualTo(List.of(12, 52, 34, 98, 2));
    }

    @Test(expected = NoSuchElementException.class)
    public void callNextAfterEndOfIterator() {
        List<Integer> list1 = Arrays.asList(12, 52);
        List<Integer> list2 = Arrays.asList(34, 98, 2);
        var compositeIterator = new CompositeIterator<>(list1.iterator(), list2.iterator());

        while (compositeIterator.hasNext()) {
            compositeIterator.next();
        }

        compositeIterator.next();
    }

    @Test
    public void testRemove() {
        Set<String> set1 = new LinkedHashSet<>() {{
            add("house");
            add("boat");
            add("sheep");
        }};
        Set<String> set2 = new LinkedHashSet<>() {{
            add("dog");
            add("car");
            add("cat");
        }};
        var compositeIterator = new CompositeIterator<>(set1.iterator(), set2.iterator());
        compositeIterator.next();
        compositeIterator.next();
        compositeIterator.remove();

        compositeIterator = new CompositeIterator<>(set1.iterator(), set2.iterator());
        var result = new ArrayList<>();
        result.add(compositeIterator.next());
        result.add(compositeIterator.next());
        result.add(compositeIterator.next());
        result.add(compositeIterator.next());

        assertThat(result).isEqualTo(List.of("house", "sheep", "dog", "car"));
        assertThat(compositeIterator.hasNext()).isEqualTo(true);
    }
}