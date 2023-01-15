package by.andd3dfx.iterators;

import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class EvenIteratorTest {

    @Test
    public void testWhenNoEvens() {
        var list = Arrays.asList(1, 3, 5, 7, 9);
        var evenIterator = new EvenIterator(list.iterator());

        assertThat(evenIterator.hasNext(), is(false));
        assertThat(evenIterator.hasNext(), is(false));
        checkExceptionWhenNextOnEmptyIterator(evenIterator);
    }

    @Test
    public void testWhenEvensOnly() {
        var list = Arrays.asList(2, 4, 8, 12);
        var evenIterator = new EvenIterator(list.iterator());

        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(2));
        assertThat(evenIterator.next(), is(4));
        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(8));
        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(12));
        assertThat(evenIterator.hasNext(), is(false));
        checkExceptionWhenNextOnEmptyIterator(evenIterator);
    }

    @Test
    public void testWhenBothEvenNOdd() {
        var list = Arrays.asList(1, 2, 3, 4, 23, 8, 12, 91);
        var evenIterator = new EvenIterator(list.iterator());

        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(2));
        assertThat(evenIterator.next(), is(4));
        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(8));
        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(12));
        assertThat(evenIterator.hasNext(), is(false));
        checkExceptionWhenNextOnEmptyIterator(evenIterator);
    }

    @Test
    public void testWhenBothEvenNOddButWithoutUsingHasNext() {
        var list = Arrays.asList(1, 2, 3, 4, 23, 8, 12, 91);
        var evenIterator = new EvenIterator(list.iterator());

        assertThat(evenIterator.next(), is(2));
        assertThat(evenIterator.next(), is(4));
        assertThat(evenIterator.next(), is(8));
        assertThat(evenIterator.next(), is(12));
        checkExceptionWhenNextOnEmptyIterator(evenIterator);
    }

    private static void checkExceptionWhenNextOnEmptyIterator(EvenIterator evenIterator) {
        try {
            evenIterator.next();
            fail("Exception should be thrown");
        } catch (NoSuchElementException nsee) {
            assertThat(nsee.getMessage(), is("Iterator is empty!"));
        }
    }
}