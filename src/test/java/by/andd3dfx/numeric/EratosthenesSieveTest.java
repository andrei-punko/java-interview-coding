package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.EratosthenesSieve.apply;
import static org.assertj.core.api.Assertions.assertThat;

public class EratosthenesSieveTest {

    @Test
    public void testApply() {
        assertThat(apply(2)).isEqualTo(0);
        assertThat(apply(5)).isEqualTo(2);
        assertThat(apply(10)).isEqualTo(4);
        assertThat(apply(15)).isEqualTo(6);
    }
}
