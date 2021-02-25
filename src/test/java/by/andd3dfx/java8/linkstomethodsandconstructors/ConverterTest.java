package by.andd3dfx.java8.linkstomethodsandconstructors;

import by.andd3dfx.java8.functionalinterface.Converter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConverterTest {

    /**
     * Same as another ConverterTest but use a link to method
     */
    @Test
    public void convert() throws Exception {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");

        assertThat("Right number expected", converted, is(123));
    }
}
