package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortedSquaresTest {

    @Test
    public void transform() {
        assertThat(SortedSquares.transform(new int[]{-5, -3, 0, 1, 2, 4}))
                .isEqualTo(new Integer[]{0, 1, 4, 9, 16, 25});
    }
}
