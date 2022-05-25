package by.andd3dfx.search;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FindNeighborhoodSequenceTest {

    @Test
    public void find() {
        assertThat(FindNeighborhoodSequence.find(new Integer[]{1, 2, 4, 6, 1, 3, 2}))
                .isEqualTo(new Integer[]{1, 3, 3, 3, 2, 2, 1});

        assertThat(FindNeighborhoodSequence.find(new Integer[]{1, 1, 3, 5}))
                .isEqualTo(new Integer[]{4, 4, 4, 4});

        assertThat(FindNeighborhoodSequence.find(new Integer[]{1, 2, 1, 2}))
                .isEqualTo(new Integer[]{1, 1, 1, 1});
    }
}