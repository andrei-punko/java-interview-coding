package by.andd3dfx.interview.train2021;

import org.junit.Test;

import java.util.Arrays;
import java.util.PrimitiveIterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EvenIteratorTest {

    @Test
    public void testWhenNoEvens() {
        EvenIterator evenIterator = buildIterator(new int[]{1, 3, 5, 7, 9});

        assertThat(evenIterator.hasNext(), is(false));
        assertThat(evenIterator.hasNext(), is(false));
    }

    @Test
    public void testWhenOnlyEvens() {
        EvenIterator evenIterator = buildIterator(new int[]{2, 6, 14});

        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(2));
        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(6));
        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(14));
        assertThat(evenIterator.hasNext(), is(false));
        assertThat(evenIterator.hasNext(), is(false));
    }

    @Test
    public void testWhenBothEvensNOdds() {
        EvenIterator evenIterator = buildIterator(new int[]{1, 3, 5, 8, 2, 1, 14, 3});

        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(8));
        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(2));
        assertThat(evenIterator.hasNext(), is(true));
        assertThat(evenIterator.next(), is(14));
        assertThat(evenIterator.hasNext(), is(false));
        assertThat(evenIterator.hasNext(), is(false));
    }

    private EvenIterator buildIterator(int[] ints) {
        PrimitiveIterator.OfInt iterator = Arrays.stream(ints).iterator();
        return new EvenIterator(iterator);
    }
}
