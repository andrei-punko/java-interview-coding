package by.andd3dfx.numeric;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AddStringsTest {

    @Test
    public void addStrings() {
        assertThat(AddStrings.addStrings("11", "123")).isEqualTo("134");
        assertThat(AddStrings.addStrings("456", "77")).isEqualTo("533");
        assertThat(AddStrings.addStrings("0", "0")).isEqualTo("0");
        assertThat(AddStrings.addStrings("1", "9")).isEqualTo("10");
        assertThat(AddStrings.addStrings("9", "99")).isEqualTo("108");

        assertThat(AddStrings.addStrings("79", "179")).isEqualTo("258");
    }
}
