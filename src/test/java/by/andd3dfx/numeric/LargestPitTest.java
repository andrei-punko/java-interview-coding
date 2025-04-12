package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.LargestPit.find;
import static org.assertj.core.api.Assertions.assertThat;

public class LargestPitTest {

    @Test
    public void testFind() {
        assertThat(find(new int[]{})).isEqualTo(0);
        assertThat(find(new int[]{1})).isEqualTo(0);
        assertThat(find(new int[]{1, 2})).isEqualTo(0);
        assertThat(find(new int[]{4, 4, 3, 2, 1, 0})).isEqualTo(-1);
        assertThat(find(new int[]{0, 0, 1, 2, 3, 4})).isEqualTo(-1);
        assertThat(find(new int[]{2, 1, 2, -1, 3})).isEqualTo(3);
        assertThat(find(new int[]{1, 0, 1, -2, 0})).isEqualTo(2);
        assertThat(find(new int[]{0, -1, 1, -2, 0, -3, 1, -4, 0, -5})).isEqualTo(4);
    }
}
