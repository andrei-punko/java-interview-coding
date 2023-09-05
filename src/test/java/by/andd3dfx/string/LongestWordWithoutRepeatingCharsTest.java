package by.andd3dfx.string;

import org.junit.Test;

import static by.andd3dfx.string.LongestWordWithoutRepeatingChars.determine;
import static org.assertj.core.api.Assertions.assertThat;

public class LongestWordWithoutRepeatingCharsTest {

    @Test
    public void testDetermine() {
        assertThat(determine("")).isEqualTo(0);
        assertThat(determine("dvdf")).isEqualTo(3);
        assertThat(determine("pwwkew")).isEqualTo(3);
        assertThat(determine("abcdef")).isEqualTo(6);
        assertThat(determine("abcadefaade")).isEqualTo(6);
        assertThat(determine("aaaaa")).isEqualTo(1);
        assertThat(determine("abaabaaa")).isEqualTo(2);
    }
}
