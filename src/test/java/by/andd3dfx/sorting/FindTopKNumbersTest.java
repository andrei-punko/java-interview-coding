package by.andd3dfx.sorting;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindTopKNumbersTest {

    @Test
    public void find() {
        assertThat(FindTopKNumbers.find(new int[]{1, 3, 4}, 2))
            .containsExactly(4, 3);
        assertThat(FindTopKNumbers.find(new int[]{1, 34, 56, 44, 0, -3, 90, 5, 3, 4}, 5))
            .containsExactly(90, 56, 44, 34, 5);
        assertThat(FindTopKNumbers.find(new int[]{1, 3, 4}, 0))
            .containsExactly();
    }
}
