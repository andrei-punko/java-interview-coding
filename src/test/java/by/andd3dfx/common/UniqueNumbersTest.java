package by.andd3dfx.common;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UniqueNumbersTest {

    @Test
    public void testFindUniqueNumbers() {
        var result = UniqueNumbers.findUniqueNumbers(Arrays.asList(1, 2, 3));

        assertThat(result.size(), is(3));
        assertThat(result, hasItems(1, 2, 3));
    }

    @Test
    public void testFindUniqueNumbersWhenEvenDuplicatesPresent() {
        var result = UniqueNumbers.findUniqueNumbers(Arrays.asList(1, 2, 1, 3));

        assertThat(result.size(), is(2));
        assertThat(result, hasItems(2, 3));
    }

    @Test
    public void testFindUniqueNumbersWhenOddDuplicatesPresent() {
        var result = UniqueNumbers.findUniqueNumbers(Arrays.asList(1, 2, 1, 3, 1));

        assertThat(result.size(), is(2));
        assertThat(result, hasItems(2, 3));
    }

    @Test
    public void testFindUniqueNumbersWhenOnlyDuplicatesPresent() {
        var result = UniqueNumbers.findUniqueNumbers(Arrays.asList(2, 2, 2, 2));

        assertThat(result.size(), is(0));
    }
}
