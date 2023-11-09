package by.andd3dfx.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class ReplaceQCharToAvoidConsecutiveRepeatingCharsTest {

    private ReplaceQCharToAvoidConsecutiveRepeatingChars instance;

    @Before
    public void setUp() throws Exception {
        instance = new ReplaceQCharToAvoidConsecutiveRepeatingChars();
    }

    @Test
    public void testModifyString() {
        var items = new String[]{"?zs", "ubv?w", "j?qg??b"};

        for (var item : items) {
            var result = instance.modifyString(item);
            checkAsserts(item, result);
        }
    }

    @Test
    public void testModifyStringForNullOrEmpty() {
        var items = new String[]{null, ""};

        for (var item : items) {
            var result = instance.modifyString(item);
            assertThat(item).isEqualTo(result);
        }
    }

    private void checkAsserts(String in, String out) {
        // The length of both strings should be the same
        assertThat(in.length()).isEqualTo(out.length());

        // Check that all non-'?' chars from initial string present in result string
        for (int i = 0; i < in.length(); i++) {
            char ch = in.charAt(i);
            if (ch != '?') {
                assertThat(ch).isEqualTo(out.charAt(i));
            }
        }

        // Check absence of '?' in result string
        assertFalse("'?' should absent in result string", out.contains("?"));

        // Check the absence of consecutive repeating characters in result string
        var last = out.charAt(0);
        for (var i = 1; i < out.length(); i++) {
            var curr = out.charAt(i);
            var errMsg = "Chars on positions %d and %d for conversion %s->%s should differ".formatted(i - 1, i, in, out);
            assertNotEquals(errMsg, curr, last);
            last = curr;
        }
    }
}
