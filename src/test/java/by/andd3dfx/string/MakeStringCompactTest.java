package by.andd3dfx.string;

import org.junit.Test;

import static by.andd3dfx.string.MakeStringCompact.build;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MakeStringCompactTest {

    @Test
    public void testBuild() {
        assertThat(build(""), is(""));
        assertThat(build("a"), is("a1"));
        assertThat(build("aaa"), is("a3"));
        assertThat(build("aaabbc"), is("a3b2c1"));
        assertThat(build("aaacbb"), is("a3c1b2"));
        assertThat(build("aaacbbccc"), is("a3c4b2"));
    }
}
