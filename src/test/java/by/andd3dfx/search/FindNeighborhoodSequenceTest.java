package by.andd3dfx.search;

import org.junit.Test;

import static by.andd3dfx.search.FindNeighborhoodSequence.find;
import static org.assertj.core.api.Assertions.assertThat;

public class FindNeighborhoodSequenceTest {

    @Test
    public void testFind() {
        assertThat(find(new int[]{1, 2, 4, 6, 1, 3, 2}))
            .isEqualTo(new int[]{1, 3, 3, 3, 2, 2, 1});

        assertThat(find(new int[]{1, 3, 5, 9}))
            .isEqualTo(new int[]{4, 4, 4, 4});

        assertThat(find(new int[]{2, 8, 90}))
            .isEqualTo(new int[]{3, 3, 3});

        assertThat(find(new int[]{1, 2, 1, 2}))
            .isEqualTo(new int[]{1, 1, 1, 1});
    }
}
