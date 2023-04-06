package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.WeekDaysEnum.MONDAY;
import static by.andd3dfx.common.WeekDaysEnum.SUNDAY;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WeekDaysEnumTest {

    @Test
    public void ordinal() {
        assertThat(SUNDAY.ordinal(), is(0));
        assertThat(MONDAY.ordinal(), is(1));
    }

    @Test
    public void name() {
        assertThat(SUNDAY.name(), is("SUNDAY"));
        assertThat(MONDAY.name(), is("MONDAY"));
    }

    @Test
    public void values() {
        WeekDaysEnum[] values = WeekDaysEnum.values();
        assertThat(values.length, is(2));
        assertThat(values[0], is(SUNDAY));
        assertThat(values[1], is(MONDAY));
    }

    @Test
    public void valueOf() {
        assertThat(WeekDaysEnum.valueOf("SUNDAY"), is(SUNDAY));
        assertThat(WeekDaysEnum.valueOf("MONDAY"), is(MONDAY));
    }
}
