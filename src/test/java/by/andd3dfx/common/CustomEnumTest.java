package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.CustomEnum.FRIDAY;
import static by.andd3dfx.common.CustomEnum.MONDAY;
import static by.andd3dfx.common.CustomEnum.SUNDAY;
import static by.andd3dfx.common.CustomEnum.WEDNESDAY;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomEnumTest {

    @Test
    public void values() {
        CustomEnum[] values = CustomEnum.values();

        assertThat(values.length).isEqualTo(7);

        assertThat(values[0]).isEqualTo(MONDAY);
        assertThat(values[6]).isEqualTo(SUNDAY);
    }

    @Test
    public void valueOf() {
        assertThat(CustomEnum.valueOf("FRIDAY")).isEqualTo(FRIDAY);
        assertThat(CustomEnum.valueOf("SUNDAY")).isEqualTo(SUNDAY);
    }

    @Test
    public void ordinal() {
        assertThat(MONDAY.ordinal()).isEqualTo(0);
        assertThat(WEDNESDAY.ordinal()).isEqualTo(2);
    }

    @Test
    public void name() {
        assertThat(SUNDAY.name()).isEqualTo("SUNDAY");
        assertThat(MONDAY.name()).isEqualTo("MONDAY");
    }
}
