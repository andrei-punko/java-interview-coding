package by.andd3dfx.string;

import org.junit.Test;

import static by.andd3dfx.string.MakeStringCompact.transform;
import static org.assertj.core.api.Assertions.assertThat;

public class MakeStringCompactTest {

    @Test
    public void testTransform() {
        assertThat(transform(null)).isNull();
        assertThat(transform("")).isEqualTo("");
        assertThat(transform("a")).isEqualTo("a");
        assertThat(transform("aaa")).isEqualTo("a3");
        assertThat(transform("aaabbc")).isEqualTo("a3b2c");
        assertThat(transform("aaacbb")).isEqualTo("a3cb2");
        assertThat(transform("aaacbbccc")).isEqualTo("a3cb2c3");
        assertThat(transform("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB"))
                .isEqualTo("A4B3C2XYZD4E3F3A6B28");
    }
}
