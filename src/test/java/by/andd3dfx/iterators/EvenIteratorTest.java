package by.andd3dfx.iterators;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Fail.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EvenIteratorTest {

    @Test
    public void testWhenNoEvens() {
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 9);
        EvenIterator evenIterator = new EvenIterator(list.iterator());

        assertThat(evenIterator.hasNext(), is(false));
        assertThat(evenIterator.hasNext(), is(false));
        checkExceptionWhenNextOnEmptyIterator(evenIterator);
    }

    @Test
    public void testWhenOnlyEvens() {
        List<Integer> list = Arrays.asList(2, 6, 14);
        EvenIterator evenIterator = new EvenIterator(list.iterator());

        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(2));
        assertThat(evenIterator.next(), is(6));
        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(14));
        assertThat(evenIterator.hasNext(), is(false));
        assertThat(evenIterator.hasNext(), is(false));
        checkExceptionWhenNextOnEmptyIterator(evenIterator);
    }

    @Test
    public void testWhenBothEvensNOddsWithUsageOfHasNext() {
        List<Integer> list = Arrays.asList(1, 3, 5, 8, 2, 1, 14, 3);
        EvenIterator evenIterator = new EvenIterator(list.iterator());

        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(8));
        assertThat(evenIterator.next(), is(2));
        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(14));
        assertThat(evenIterator.hasNext(), is(false));
        assertThat(evenIterator.hasNext(), is(false));
        checkExceptionWhenNextOnEmptyIterator(evenIterator);
    }

    @Test
    public void testWhenBothEvensNOddsWithoutUsageOfHasNext() {
        List<Integer> list = Arrays.asList(1, 3, 5, 8, 2, 1, 14, 3);
        var evenIterator = new EvenIterator(list.iterator());

        var result = new ArrayList<>();
        while (evenIterator.hasNext()) {
            Integer item = evenIterator.next();
            result.add(item);
        }
        assertThat(evenIterator.hasNext(), is(false));

        Assertions.assertThat(result).isEqualTo(List.of(8, 2, 14));
        checkExceptionWhenNextOnEmptyIterator(evenIterator);
    }

    private void checkExceptionWhenNextOnEmptyIterator(EvenIterator evenIterator) {
        try {
            evenIterator.next();
            fail("Exception should be thrown");
        } catch (NoSuchElementException nse) {
            assertThat(nse.getMessage(), is("Iterator is empty!"));
        }
    }
}
