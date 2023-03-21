package by.andd3dfx.java8.linkstomethodsandconstructors;

import by.andd3dfx.java8.functionalinterface.Converter;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SomethingTest {

    private Something something;

    @Before
    public void setUp() throws Exception {
        something = new Something();
    }

    @Test
    public void startsWith() {
        Converter<String, String> converter = something::startsWith;

        String converted = converter.convert("Java");

        assertThat("First character expected", converted, is("J"));
    }
}
