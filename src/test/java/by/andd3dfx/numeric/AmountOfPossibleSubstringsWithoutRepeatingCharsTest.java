package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.AmountOfPossibleSubstringsWithoutRepeatingChars.determine;
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
