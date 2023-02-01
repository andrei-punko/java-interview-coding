package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.SimpleDividers.determine;
import static org.assertj.core.api.Assertions.assertThat;

public class SimpleDividersTest {

    @Test
    public void testDetermine() {
        assertThat(determine(3)).containsExactly(3);
        assertThat(determine(11)).containsExactly(11);
        assertThat(determine(37)).containsExactly(37);

        assertThat(determine(21)).containsExactly(3, 7);
        assertThat(determine(36)).containsExactly(2, 2, 3, 3);
        assertThat(determine(100)).containsExactly(2, 2, 5, 5);
    }
}
