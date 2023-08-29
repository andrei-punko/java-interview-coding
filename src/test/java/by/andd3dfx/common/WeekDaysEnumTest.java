package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.WeekDaysEnum.MONDAY;
import static by.andd3dfx.common.WeekDaysEnum.SUNDAY;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WeekDaysEnumTest {

    @Test
    public void ordinal() {
        assertThat(MONDAY.ordinal(), is(0));
        assertThat(SUNDAY.ordinal(), is(6));
    }

    @Test
    public void name() {
        assertThat(SUNDAY.name(), is("SUNDAY"));
        assertThat(MONDAY.name(), is("MONDAY"));
    }

    @Test
    public void values() {
        WeekDaysEnum[] values = WeekDaysEnum.values();
        assertThat(values.length, is(7));
        assertThat(values[0], is(MONDAY));
        assertThat(values[6], is(SUNDAY));
    }

    @Test
    public void valueOf() {
        assertThat(WeekDaysEnum.valueOf("SUNDAY"), is(SUNDAY));
        assertThat(WeekDaysEnum.valueOf("MONDAY"), is(MONDAY));
    }
}
