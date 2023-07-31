package by.andd3dfx.string;

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

    @Test
    public void indexOfWhenPatternHappensOneTime() {
        assertThat(indexOf("abacaba abracadabra baba", "abracadabra"))
                .isEqualTo(8);
    }

    @Test
    public void indexOfWhenPatternHappensMultipleTimes() {
        assertThat(indexOf("o on one one one on o", "one"))
                .isEqualTo(5);
    }
}
