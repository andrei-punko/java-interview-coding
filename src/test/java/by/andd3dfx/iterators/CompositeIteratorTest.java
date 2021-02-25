package by.andd3dfx.iterators;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

public class CompositeIteratorTest {

    @Test
    public void testNextAndHasNext() {
        List<Integer> list1 = Arrays.asList(12, 52);
        List<Integer> list2 = Arrays.asList(34, 98, 2);
        CompositeIterator<Integer> compositeIterator = new CompositeIterator(list1.iterator(), list2.iterator());

        List<Integer> result = new ArrayList<>();

        while (compositeIterator.hasNext()) {
            Integer value = compositeIterator.next();
            result.add(value);

            System.out.println(value);
        }

        assertThat("Wrong result", result.toString(), is("[12, 52, 34, 98, 2]"));
    }

    @Test
    public void remove() {
        Set<String> set1 = new TreeSet<String>() {{
            add("house");
            add("boat");
            add("sheep");
        }};
        Set<String> set2 = new TreeSet<String>() {{
            add("dog");
            add("car");
            add("cat");
        }};
        CompositeIterator<String> compositeIterator = new CompositeIterator(set1.iterator(), set2.iterator());

        List<String> list = new ArrayList<>();
        list.add(compositeIterator.next());
        list.add(compositeIterator.next());
        compositeIterator.remove();
        list.add(compositeIterator.next());
        list.add(compositeIterator.next());
        compositeIterator.remove();

        assertThat("Wrong list", list.toString(), is("[boat, house, sheep, car]"));
        assertThat("Wrong set1", set1.toString(), is("[boat, sheep]"));
        assertThat("Wrong set2", set2.toString(), is("[cat, dog]"));
    }

    @Test(expected = NoSuchElementException.class)
    public void callNextAfterEndOfIterator() {
        List<Integer> list1 = Arrays.asList(12, 52);
        List<Integer> list2 = Arrays.asList(34, 98, 2);
        CompositeIterator<Integer> compositeIterator = new CompositeIterator(list1.iterator(), list2.iterator());

        while (compositeIterator.hasNext()) {
            compositeIterator.next();
        }

        compositeIterator.next();
    }
}
