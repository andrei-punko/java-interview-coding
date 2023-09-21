package by.andd3dfx.numeric;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveZeroesTest {

    @Test
    public void moveZeroes() {
        var items = new int[]{0, 1, 0, 3, 12};

        MoveZeroes.moveZeroes(items);

        assertThat(items).isEqualTo(new int[]{1, 3, 12, 0, 0});
    }

    @Test
    public void moveZeroesWhenZerosOnly() {
        var items = new int[]{0, 0, 0};

        MoveZeroes.moveZeroes(items);

        assertThat(items).isEqualTo(new int[]{0, 0, 0});
    }
}
