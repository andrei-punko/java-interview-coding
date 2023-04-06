package by.andd3dfx.string;

import org.junit.Test;

import static by.andd3dfx.string.MakeStringCompact.transform;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MakeStringCompactTest {

    @Test
    public void testTransform() {
        assertThat(transform(""), is(""));
        assertThat(transform("a"), is("a1"));
        assertThat(transform("aaa"), is("a3"));
        assertThat(transform("aaabbc"), is("a3b2c1"));
        assertThat(transform("aaacbb"), is("a3c1b2"));
        assertThat(transform("aaacbbccc"), is("a3c4b2"));
    }
}