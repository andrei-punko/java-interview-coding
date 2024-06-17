package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.CountOnesInBinaryForm.count;
import static org.assertj.core.api.Assertions.assertThat;

public class CountOnesInBinaryFormTest {

    @Test
    public void testCount() {
        assertThat(count(1)).isEqualTo(1);
        assertThat(count(2)).isEqualTo(1);
        assertThat(count(3)).isEqualTo(2);
        assertThat(count(255)).isEqualTo(8);
        assertThat(count(984)).isEqualTo(6);
        assertThat(count(8954)).isEqualTo(8);
        assertThat(count(69587)).isEqualTo(10);

    }
}
