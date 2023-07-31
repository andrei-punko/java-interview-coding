package by.andd3dfx.string;

import org.junit.Test;

import static by.andd3dfx.string.FindSubstring.indexOf_NM;
import static by.andd3dfx.string.FindSubstring.indexOf_NPlusM;
import static org.assertj.core.api.Assertions.assertThat;

public class FindSubstringTest {

    // indexOf_NM tests

    @Test
    public void indexOf_NM_whenPatternLongerThanText() {
        assertThat(indexOf_NM("abc", "mnklkmab"))
                .isEqualTo(-1);
    }

    @Test
    public void indexOf_NM_when_textNPatternAreTheSame() {
        assertThat(indexOf_NM("aba", "aba"))
                .isEqualTo(0);
    }

    @Test
    public void indexOf_NM_whenPatternIsAbsentInText() {
        assertThat(indexOf_NM("I'm looking for something special", "Captain Jack"))
                .isEqualTo(-1);
    }

    @Test
    public void indexOf_NM_whenPatternHappensOneTime() {
        assertThat(indexOf_NM("abacaba abracadabra baba", "abracadabra"))
                .isEqualTo(8);
        assertThat(indexOf_NM("kura bura kura2 kuranda da", "kuranda"))
                .isEqualTo(16);
    }

    @Test
    public void indexOf_NM_whenPatternHappensMultipleTimes() {
        assertThat(indexOf_NM("o on one one one on o", "one"))
                .isEqualTo(5);
    }

    // indexOf_NPlusM tests

    @Test
    public void indexOf_NPlusM_whenPatternLongerThanText() {
        assertThat(indexOf_NPlusM("abc", "mnklkmab"))
                .isEqualTo(-1);
    }

    @Test
    public void indexOf_NPlusM_when_textNPatternAreTheSame() {
        assertThat(indexOf_NPlusM("aba", "aba"))
                .isEqualTo(0);
    }

    @Test
    public void indexOf_NPlusM_whenPatternIsAbsentInText() {
        assertThat(indexOf_NPlusM("I'm looking for something special", "Captain Jack"))
                .isEqualTo(-1);
    }

    @Test
    public void indexOf_NPlusM_whenPatternHappensOneTime() {
        assertThat(indexOf_NPlusM("abacaba abracadabra baba", "abracadabra"))
                .isEqualTo(8);
        assertThat(indexOf_NPlusM("kura bura kura2 kuranda da", "kuranda"))
                .isEqualTo(16);
    }

    @Test
    public void indexOf_NPlusM_whenPatternHappensMultipleTimes() {
        assertThat(indexOf_NPlusM("o on one one one on o", "one"))
                .isEqualTo(5);
    }
}
