package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.RomanToInteger.romanToInt;
import static org.assertj.core.api.Assertions.assertThat;

public class RomanToIntegerTest {

    @Test
    public void testRomanToInt() {
        assertThat(romanToInt("I")).isEqualTo(1);
        assertThat(romanToInt("II")).isEqualTo(2);
        assertThat(romanToInt("III")).isEqualTo(3);
        assertThat(romanToInt("IV")).isEqualTo(4);
        assertThat(romanToInt("V")).isEqualTo(5);
        assertThat(romanToInt("VI")).isEqualTo(6);
        assertThat(romanToInt("VII")).isEqualTo(7);
        assertThat(romanToInt("VIII")).isEqualTo(8);
        assertThat(romanToInt("IX")).isEqualTo(9);
        assertThat(romanToInt("X")).isEqualTo(10);
        assertThat(romanToInt("LVIII")).isEqualTo(58);
        assertThat(romanToInt("MCMXCIV")).isEqualTo(1994);
        assertThat(romanToInt("MMXI")).isEqualTo(2011);
    }
}
