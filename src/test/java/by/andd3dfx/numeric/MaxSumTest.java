package by.andd3dfx.numeric;

import org.junit.Test;

import java.util.List;

import static by.andd3dfx.numeric.MaxSum.find;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class MaxSumTest {

    @Test
    public void testFind() {
        assertThat(find(List.of(3, 2))).isEqualTo(5);
        assertThat(find(List.of(5, 9, 7, 11))).isEqualTo(20);
        assertThat(find(List.of(9, 5, 1, 9))).isEqualTo(18);
    }

    @Test
    public void testFindWhenWrongInput() {
        makeCallAndCheckExceptionThrow(null);
        makeCallAndCheckExceptionThrow(List.of());
        makeCallAndCheckExceptionThrow(List.of(7));
    }

    private void makeCallAndCheckExceptionThrow(List<Integer> list) {
        var ex = assertThrows(IllegalArgumentException.class, () -> find(list));
        assertThat(ex.getMessage()).isEqualTo("List size should be 2 at least!");
    }
}
