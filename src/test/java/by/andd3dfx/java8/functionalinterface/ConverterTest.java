package by.andd3dfx.java8.functionalinterface;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConverterTest {

    @Test
    public void convert() {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");

        assertThat("Right number expected", converted, is(123));
    }
}
