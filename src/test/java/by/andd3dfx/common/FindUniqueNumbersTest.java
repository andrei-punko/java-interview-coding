package by.andd3dfx.common;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FindUniqueNumbersTest {

    @Test
    public void testFind() {
        var result = FindUniqueNumbers.find(Arrays.asList(1, 2, 3));

        assertThat(result.size(), is(3));
        assertThat(result, hasItems(1, 2, 3));
    }

    @Test
    public void testFindWhenEvenDuplicatesPresent() {
        var result = FindUniqueNumbers.find(Arrays.asList(1, 2, 1, 3));

        assertThat(result.size(), is(2));
        assertThat(result, hasItems(2, 3));
    }

    @Test
    public void testFindWhenOddDuplicatesPresent() {
        var result = FindUniqueNumbers.find(Arrays.asList(1, 2, 1, 3, 1));

        assertThat(result.size(), is(2));
        assertThat(result, hasItems(2, 3));
    }

    @Test
    public void testFindWhenOnlyDuplicatesPresent() {
        var result = FindUniqueNumbers.find(Arrays.asList(2, 2, 2, 2));

        assertThat(result.size(), is(0));
    }
}
