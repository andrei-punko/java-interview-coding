package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.CustomEnum.FRIDAY;
import static by.andd3dfx.common.CustomEnum.MONDAY;
import static by.andd3dfx.common.CustomEnum.SUNDAY;
import static by.andd3dfx.common.CustomEnum.WEDNESDAY;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomEnumTest {

    @Test
    public void values() {
        CustomEnum[] values = CustomEnum.values();

        assertThat(values.length, is(7));

        assertThat(values[0], is(MONDAY));
        assertThat(values[6], is(SUNDAY));
    }

    @Test
    public void valueOf() {
        assertThat(CustomEnum.valueOf("FRIDAY"), is(FRIDAY));
        assertThat(CustomEnum.valueOf("SUNDAY"), is(SUNDAY));
    }

    @Test
    public void ordinal() {
        assertThat(MONDAY.ordinal(), is(0));
        assertThat(WEDNESDAY.ordinal(), is(2));
    }

    @Test
    public void name() {
        assertThat(SUNDAY.name(), is("SUNDAY"));
        assertThat(MONDAY.name(), is("MONDAY"));
    }
}
