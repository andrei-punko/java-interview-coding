package by.andd3dfx.interview.train2021;

import org.junit.Test;

import static by.andd3dfx.interview.train2021.CustomEnum.MONDAY;
import static by.andd3dfx.interview.train2021.CustomEnum.SUNDAY;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomEnumTest {

    @Test
    public void values() {
        CustomEnum[] result = CustomEnum.values();

        assertThat("Wrong size", result.length, is(2));

        assertThat("Wrong entity, SUNDAY expected", result[0], is(SUNDAY));
        assertThat("Wrong entity, MONDAY expected", result[1], is(MONDAY));
    }

    @Test
    public void valueOf() {
        CustomEnum result = CustomEnum.valueOf("MONDAY");

        assertThat("Wrong entity, MONDAY expected", result, is(MONDAY));
    }

    @Test
    public void ordinal() {
        assertThat("Ordinal value 0 expected", SUNDAY.ordinal(), is(0));
        assertThat("Ordinal value 1 expected", MONDAY.ordinal(), is(1));
    }

    @Test
    public void name() {
        assertThat("SUNDAY expected", SUNDAY.name(), is("SUNDAY"));
        assertThat("MONDAY expected", MONDAY.name(), is("MONDAY"));
    }
}