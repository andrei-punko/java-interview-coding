package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.KNearestNumbers.determine;
import static org.assertj.core.api.Assertions.assertThat;

public class KNearestNumbersTest {

    @Test
    public void testDetermine() {
        assertThat(determine(new int[]{1, 2, 2, 3, 4, 4, 4, 5, 6}, 4, 2))
                .containsExactlyInAnyOrder(4, 4);
        assertThat(determine(new int[]{1, 2, 3, 4, 5, 6}, 3, 2))
                .containsExactlyInAnyOrder(4, 5);   // TODO: somehow add assert `expect one result OR another` (check examples in task definition)
        assertThat(determine(new int[]{1, 2, 3, 4, 5, 6}, 0, 3))
                .containsExactlyInAnyOrder(1, 2, 3);
        assertThat(determine(new int[]{1, 2, 2, 3, 3, 56, 78, 79, 79, 100}, 4, 3))
                .containsExactlyInAnyOrder(3, 3, 2);
    }
}
