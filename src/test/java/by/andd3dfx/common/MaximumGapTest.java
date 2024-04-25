package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.MaximumGap.determine;
import static org.assertj.core.api.Assertions.assertThat;

public class MaximumGapTest {

    @Test
    public void testDetermine() {
        assertThat(determine(new int[]{3, 6, 9, 1})).isEqualTo(3);
        assertThat(determine(new int[]{3, 49, 1, 9, 2})).isEqualTo(40);
        assertThat(determine(new int[]{10})).isEqualTo(0);
    }
}
