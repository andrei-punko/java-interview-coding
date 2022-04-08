package by.andd3dfx.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MakeStringCompactTest {

    @Test
    public void convert() {
        assertThat(MakeStringCompact.convert("")).isEqualTo("");
        assertThat(MakeStringCompact.convert("A")).isEqualTo("A");
        assertThat(MakeStringCompact.convert("ABC")).isEqualTo("ABC");
        assertThat(MakeStringCompact.convert("AAABBCDDDDEFFFFFFFFFF")).isEqualTo("A3B2CD4EF10");
    }
}
