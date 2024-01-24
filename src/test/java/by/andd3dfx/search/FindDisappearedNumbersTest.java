package by.andd3dfx.search;

import org.junit.Test;

import static by.andd3dfx.search.FindDisappearedNumbers.find;
import static org.assertj.core.api.Assertions.assertThat;

public class FindDisappearedNumbersTest {

    @Test
    public void testFindForEmptyArray() {
        assertThat(find(new int[]{})).isEmpty();
    }

    @Test
    public void testFindWhenAllNumbersPresent() {
        assertThat(find(new int[]{1, 2, 3, 4, 5})).isEmpty();
        assertThat(find(new int[]{3, 2, 1, 5, 4})).isEmpty();
    }

    @Test
    public void testFind() {
        assertThat(find(new int[]{1, 1, 1, 1, 1})).containsExactly(2, 3, 4, 5);
        assertThat(find(new int[]{1, 1, 1, 2, 4})).containsExactly(3, 5);
        assertThat(find(new int[]{3, 3, 5, 5, 2})).containsExactly(1, 4);
    }
}
