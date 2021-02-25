package by.andd3dfx.iterators;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.Test;

public class RecursiveIteratorTest {
    @Test
    public void testNextAndHasNextForPlainList() {
        List<String> list = Arrays.asList("1", "3", "5", "7", "90");
        RecursiveIterator iterator = new RecursiveIterator(list.iterator());
        List<String> result = new ArrayList<>();

        while (iterator.hasNext()) {
            Object object = iterator.next();
            result.add((String) object);
        }

        assertThat("Wrong result", result.toString(), is("[1, 3, 5, 7, 90]"));
    }

    @Test
    public void testNextAndHasNextForComplexStructure() {
        List<Object> list1 = Arrays.asList("23", "31", Arrays.asList().iterator());
        List<Object> list2 = Arrays.asList("3", "9", "4", list1.iterator());
        List<Object> list3 = Arrays.asList("1", list2.iterator(), "88");
        List<Object> list4 = Arrays.asList("5", "37", Arrays.asList().iterator());
        List<Object> list = Arrays.asList(list3.iterator(), "22", list4.iterator(), "11");
        RecursiveIterator iterator = new RecursiveIterator(list.listIterator());
        List<String> result = new ArrayList<>();

        while (iterator.hasNext()) {
            Object object = iterator.next();
            result.add((String) object);
        }

        assertThat("Wrong result", result.toString(), is("[1, 3, 9, 4, 23, 31, 88, 22, 5, 37, 11]"));
    }

    @Test(expected = NoSuchElementException.class)
    public void callNextAfterEndOfIterator() {
        List<String> list = Arrays.asList("1", "3", "5", "7", "90");
        RecursiveIterator iterator = new RecursiveIterator(list.iterator());

        while (iterator.hasNext()) {
            iterator.next();
        }

        iterator.next();
    }
}
