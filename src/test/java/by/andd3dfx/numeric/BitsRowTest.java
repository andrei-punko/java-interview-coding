package by.andd3dfx.numeric;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BitsRowTest {

    @Test
    public void determineBit() {
        assertThat(BitsRow.determineBit(0)).isEqualTo(1);
        assertThat(BitsRow.determineBit(1)).isEqualTo(0);
        assertThat(BitsRow.determineBit(2)).isEqualTo(1);
        assertThat(BitsRow.determineBit(14)).isEqualTo(1);
        assertThat(BitsRow.determineBit(15)).isEqualTo(0);
    }
}
