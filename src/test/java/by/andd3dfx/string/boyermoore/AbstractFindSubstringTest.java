package by.andd3dfx.string.boyermoore;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractFindSubstringTest {

    protected IFindSubstring findSubstring;

    @Before
    public void setUp() throws Exception {
        findSubstring = initiate();
    }

    protected abstract IFindSubstring initiate();

    @Test
    public void indexOfWhenPatternLongerThanText() {
        assertThat(findSubstring.indexOf("abc", "mnklkmab"))
                .isEqualTo(-1);
    }

    @Test
    public void indexOfWhenTextNPatternAreTheSame() {
        assertThat(findSubstring.indexOf("aba", "aba"))
                .isEqualTo(0);
    }

    @Test
    public void indexOfWhenPatternIsAbsentInText() {
        assertThat(findSubstring.indexOf("I'm looking for something special", "Captain Jack"))
                .isEqualTo(-1);
    }

    /**
     * Example from Rod Stephens book
     */
    @Test
    public void indexOfWhenPatternHappensOneTime() {
        assertThat(findSubstring.indexOf("abba daba abadabracadabra", "cadabra"))
                .isEqualTo(18);
    }

    @Test
    public void indexOfWhenPatternHappensMultipleTimes() {
        assertThat(findSubstring.indexOf("o on one one one on o", "one"))
                .isEqualTo(5);
    }

    @Test
    public void indexOfForLongText() {
        assertThat(findSubstring.indexOf("Начало помрачения ума, первый признак помрачения, усматриваемый в душе, состоит " +
                "в лености к службе Божией и молитве. Другого пути к обольщению души нет, если она прежде " +
                "не оставит этого подвига своего. Когда же она лишится помощи Божией: тогда она удобно впадает " +
                "в руки супостатов своих", "обольщению"))
                .isEqualTo(132);
    }

    @Test
    public void leetcodeTrickyTestCases() {
        assertThat(findSubstring.indexOf("ababbbbaaabbbaaa", "bbbb"))
                .isEqualTo(3);
        assertThat(findSubstring.indexOf("babbbbbabb", "bbab"))
                .isEqualTo(5);
    }
}
