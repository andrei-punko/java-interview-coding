package by.andd3dfx.string;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReplaceSpacesTest {

    private ReplaceSpaces replaceSpaces;

    @Before
    public void setUp() {
        replaceSpaces = new ReplaceSpaces();
    }

    @Test
    public void normalize() {
        assertThat(replaceSpaces.normalize("some    string  ".toCharArray()), is("some string ".toCharArray()));
    }
}