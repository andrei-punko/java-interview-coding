package by.andd3dfx.string;

import org.junit.Test;

import static by.andd3dfx.string.ReverseString.apply;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReverseStringTest {

    @Test
    public void emptyString() {
        assertThat(apply(""), is(""));
    }

    @Test
    public void oneCharacterString() {
        assertThat(apply("A"), is("A"));
    }

    @Test
    public void usualString() {
        assertThat(apply("aBc deF"), is("Fed cBa"));
    }
}
