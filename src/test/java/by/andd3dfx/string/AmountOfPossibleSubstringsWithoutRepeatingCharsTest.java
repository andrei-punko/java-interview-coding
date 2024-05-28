package by.andd3dfx.string;

import org.junit.Test;

import static by.andd3dfx.string.AmountOfPossibleSubstringsWithoutRepeatingChars.determine;
import static org.assertj.core.api.Assertions.assertThat;

public class AmountOfPossibleSubstringsWithoutRepeatingCharsTest {

    @Test
    public void testDetermine() {
        assertThat(determine("a")).isEqualTo(1);
        assertThat(determine("ab")).isEqualTo(3);
        assertThat(determine("abc")).isEqualTo(6);
        assertThat(determine("aba")).isEqualTo(5);
        assertThat(determine("abcdb")).isEqualTo(13);
    }
}
