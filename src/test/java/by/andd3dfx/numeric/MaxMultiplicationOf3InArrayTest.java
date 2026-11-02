package by.andd3dfx.numeric;

import org.junit.jupiter.api.Test;

import static by.andd3dfx.numeric.MaxMultiplicationOf3InArray.find;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaxMultiplicationOf3InArrayTest {

    @Test
    public void findWhenEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            find(new int[]{});
        });
    }

    @Test
    public void findWhenLessThan3ElementsInArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            find(new int[]{2, 9});
        });
    }

    @Test
    public void testFind() {
        assertThat(find(new int[]{1, 4, 3, 8, 1}))
            .as("All positive")
            .isEqualTo(96L);
        assertThat(find(new int[]{1, -3, 4, 8, 2}))
            .as("One negative")
            .isEqualTo(64L);
        assertThat(find(new int[]{-1, 3, 4, -2, 1}))
            .as("Two negative")
            .isEqualTo(12L);
        assertThat(find(new int[]{-1, -3, -4, -2, -1}))
            .as("All negative")
            .isEqualTo(-2L);
    }
}
