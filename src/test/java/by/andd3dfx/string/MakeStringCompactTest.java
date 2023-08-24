package by.andd3dfx.string;

import org.junit.Test;

import static by.andd3dfx.string.MakeStringCompact.transform;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class MakeStringCompactTest {

    @Test
    public void testTransform() {
        assertThat(transform(null), is(nullValue()));
        assertThat(transform(""), is(""));
        assertThat(transform("a"), is("a"));
        assertThat(transform("aaa"), is("a3"));
        assertThat(transform("aaabbc"), is("a3b2c"));
        assertThat(transform("aaacbb"), is("a3cb2"));
        assertThat(transform("aaacbbccc"), is("a3cb2c3"));
        assertThat(transform("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB"), is("A4B3C2XYZD4E3F3A6B28"));
    }
}
