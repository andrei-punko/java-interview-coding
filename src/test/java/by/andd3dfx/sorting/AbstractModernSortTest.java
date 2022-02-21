package by.andd3dfx.sorting;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public abstract class AbstractModernSortTest {

    private final Long TOO_LOW_VALUE = Long.MIN_VALUE + 52;
    private final Long TOO_HIGH_VALUE = Long.MAX_VALUE - 34;
    private AbstractModernSort sorterClass;

    @Before
    public void setup() {
        sorterClass = createSorterClass();
    }

    protected abstract AbstractModernSort createSorterClass();

    @Test
    public void sort() {
        Long[] items = new Long[]{10L, TOO_HIGH_VALUE, 9L, 8L, TOO_LOW_VALUE, 7L, 6L, 5L, 4L, 1L, 3L, 2L};
        sorterClass.insert(items);

        sorterClass.sort();

        assertThat("Wrong elements order", sorterClass.getItems(),
                is(new long[]{TOO_LOW_VALUE, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, TOO_HIGH_VALUE}));
    }
}
