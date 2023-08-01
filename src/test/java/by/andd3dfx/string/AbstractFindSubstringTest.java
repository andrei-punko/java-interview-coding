package by.andd3dfx.string;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractFindSubstringTest {

    public abstract int indexOf(String text, String pattern);

    @Test
    public void indexOfWhenPatternLongerThanText() {
        assertThat(indexOf("abc", "mnklkmab"))
                .isEqualTo(-1);
    }

    @Test
    public void indexOfWhenTextNPatternAreTheSame() {
        assertThat(indexOf("aba", "aba"))
                .isEqualTo(0);
    }

    @Test
    public void indexOfWhenPatternIsAbsentInText_sameAlphabets() {
        assertThat(indexOf("I'm looking for something special", "Captain Jack"))
                .isEqualTo(-1);
    }

    @Test
    public void indexOfWhenPatternIsAbsentInText_differentAlphabets() {
        assertThat(indexOf("I'm looking for something special", "12345"))
                .isEqualTo(-1);
    }

    /**
     * Example from Rod Stephens book
     */
    @Test
    public void indexOfWhenPatternHappensOneTime() {
        assertThat(indexOf("abba daba abadabracadabra", "cadabra"))
                .isEqualTo(18);
    }

    @Test
    public void indexOfWhenPatternHappensMultipleTimes() {
        assertThat(indexOf("o on one one one on o", "one"))
                .isEqualTo(5);
    }

    @Test
    public void indexOfForLongText() {
        assertThat(indexOf("Начало помрачения ума, первый признак помрачения, усматриваемый в душе, состоит " +
                "в лености к службе Божией и молитве. Другого пути к обольщению души нет, если она прежде " +
                "не оставит этого подвига своего. Когда же она лишится помощи Божией: тогда она удобно впадает " +
                "в руки супостатов своих", "обольщению"))
                .isEqualTo(132);
    }

    @Ignore("Fix when you will have enough time")
    @Test
    public void leetcodeTestCase() {
        assertThat(indexOf("ababbbbaaabbbaaa", "bbbb"))
                .isEqualTo(3);
        assertThat(indexOf("babbbbbabb", "bbab"))
                .isEqualTo(5);
    }
}
