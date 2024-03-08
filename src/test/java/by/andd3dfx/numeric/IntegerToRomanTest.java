package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.IntegerToRoman.intToRoman;
import static org.assertj.core.api.Assertions.assertThat;

public class IntegerToRomanTest {

    @Test
    public void testIntToRoman() {
        assertThat(intToRoman(1)).isEqualTo("I");
        assertThat(intToRoman(2)).isEqualTo("II");
        assertThat(intToRoman(3)).isEqualTo("III");
        assertThat(intToRoman(4)).isEqualTo("IV");
        assertThat(intToRoman(5)).isEqualTo("V");
        assertThat(intToRoman(6)).isEqualTo("VI");
        assertThat(intToRoman(7)).isEqualTo("VII");
        assertThat(intToRoman(8)).isEqualTo("VIII");
        assertThat(intToRoman(9)).isEqualTo("IX");
        assertThat(intToRoman(10)).isEqualTo("X");
        assertThat(intToRoman(58)).isEqualTo("LVIII");
        assertThat(intToRoman(1994)).isEqualTo("MCMXCIV");
        assertThat(intToRoman(2011)).isEqualTo("MMXI");
    }
}
