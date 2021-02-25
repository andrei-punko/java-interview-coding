package by.andd3dfx.java8.linkstomethodsandconstructors;

import by.andd3dfx.java8.functionalinterface.Converter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SomethingTest {

    @Test
    public void startsWith() throws Exception {
        Something something = new Something();
        Converter<String, String> converter = something::startsWith;

        String converted = converter.convert("Java");

        assertThat("First character expected", converted, is("J"));
    }
}
