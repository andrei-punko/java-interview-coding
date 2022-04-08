package by.andd3dfx.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MakeStringCompactTest {

    @Test
    public void convert() {
        assertThat(MakeStringCompact.convert("")).isEqualTo("");
        assertThat(MakeStringCompact.convert("A")).isEqualTo("A1");
        assertThat(MakeStringCompact.convert("ABC")).isEqualTo("A1B1C1");
        assertThat(MakeStringCompact.convert("AAABBCDDDDEFFFFFFFFFF")).isEqualTo("A3B2C1D4E1F10");
    }
}
