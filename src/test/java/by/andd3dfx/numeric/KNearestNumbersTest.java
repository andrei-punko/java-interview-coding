package by.andd3dfx.numeric;

import org.junit.Test;

import java.util.Arrays;

import static by.andd3dfx.numeric.KNearestNumbers.find;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class KNearestNumbersTest {

    @Test
    public void testFind() {
        assertThat(find(new int[]{1, 2, 2, 3, 4, 4, 4, 5, 6}, 4, 0))
                .isEmpty();
        assertThat(find(new int[]{1, 2, 2, 3, 4, 4, 4, 5, 6}, 4, 2))
                .containsExactlyInAnyOrder(4, 4);

        var result = find(new int[]{1, 2, 3, 4, 5, 6}, 3, 2);
        assertTrue(
                Arrays.equals(result, new int[]{4, 3}) ||
                        Arrays.equals(result, new int[]{4, 5})
        );

        assertThat(find(new int[]{1, 2, 3, 4, 5, 6}, 0, 3))
                .containsExactlyInAnyOrder(1, 2, 3);
        assertThat(find(new int[]{1, 2, 2, 3, 3, 56, 78, 79, 79, 100}, 4, 3))
                .containsExactlyInAnyOrder(3, 3, 2);
    }

    @Test
    public void testFind_whenIIndexIsOutOfRange() {
        checkExMsg_whenIIndexIsOutOfRange(() -> find(new int[]{2, 6, 7}, 5, 1));
        checkExMsg_whenIIndexIsOutOfRange(() -> find(new int[]{}, 1, 1));
    }

    private static void checkExMsg_whenIIndexIsOutOfRange(Runnable runnable) {
        var ex = assertThrows(IllegalArgumentException.class, () -> runnable.run());
        assertThat(ex.getMessage()).isEqualTo("Index `i` is out of array's range!");
    }

    @Test
    public void testFind_whenKIsNegative() {
        var ex = assertThrows(IllegalArgumentException.class, () -> find(new int[]{2, 6, 7}, 1, -2));
        assertThat(ex.getMessage()).isEqualTo("Requested amount of items `k` is negative!");
    }
}
