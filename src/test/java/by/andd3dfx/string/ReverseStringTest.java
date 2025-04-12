package by.andd3dfx.string;

import org.junit.Test;

import static by.andd3dfx.string.ReverseString.apply;
import static org.assertj.core.api.Assertions.assertThat;

public class ReverseStringTest {

    @Test
    public void testApply() {
        assertThat(apply("")).isEqualTo("");
        assertThat(apply("A")).isEqualTo("A");
        assertThat(apply("aBc deF")).isEqualTo("Fed cBa");
    }
}
