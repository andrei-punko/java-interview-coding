package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortedSquaresTest {

    public static final Integer[] INITIAL_ARRAY = {-5, -3, 0, 1, 2, 4};
    public static final Integer[] EXPECTED_ARRAY = {0, 1, 4, 9, 16, 25};

    @Test
    public void transformUsingSorting() {
        assertThat(SortedSquares.transformUsingSorting(INITIAL_ARRAY))
            .isEqualTo(EXPECTED_ARRAY);
    }

    @Test
    public void transformUsingDeque() {
        assertThat(SortedSquares.transformUsingDeque(INITIAL_ARRAY))
            .isEqualTo(EXPECTED_ARRAY);
    }

    @Test
    public void transformUsingPriorityQueue() {
        assertThat(SortedSquares.transformUsingPriorityQueue(INITIAL_ARRAY))
            .isEqualTo(EXPECTED_ARRAY);
    }
}
