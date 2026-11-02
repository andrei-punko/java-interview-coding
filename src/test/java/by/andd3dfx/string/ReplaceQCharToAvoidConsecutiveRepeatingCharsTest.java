package by.andd3dfx.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ReplaceQCharToAvoidConsecutiveRepeatingCharsTest {

    private ReplaceQCharToAvoidConsecutiveRepeatingChars instance;

    @BeforeEach
    public void setUp() throws Exception {
        instance = new ReplaceQCharToAvoidConsecutiveRepeatingChars();
    }

    @Test
    public void modifyString() {
        var items = new String[]{"?zs", "ubv?w", "x?y??z?", "j?qg??b"};

        for (var item : items) {
            var result = instance.modifyString(item);
            System.out.println(item + "->" + result);
            checkAsserts(item, result);
        }
    }

    @Test
    public void modifyStringForNullOrEmpty() {
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
            var ch = in.charAt(i);
            if (ch != '?') {
                assertThat(ch).isEqualTo(out.charAt(i));
            }
        }

        // Check absence of '?' in result string
        assertFalse(out.contains("?"), "'?' should absent in result string");

        // Check the absence of consecutive repeating characters in result string
        var last = out.charAt(0);
        for (var i = 1; i < out.length(); i++) {
            var curr = out.charAt(i);
            var errMsg = "Chars on positions %d and %d for conversion %s->%s should differ"
                .formatted(i - 1, i, in, out);
            assertNotEquals(curr, last, errMsg);
            last = curr;
        }
    }
}
