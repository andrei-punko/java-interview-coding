package by.andd3dfx.string;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringUtilTest {

    @Test
    public void revert() throws Exception {

        assertThat("revert for empty string", StringUtil.revert(""), is(""));
        assertThat("revert for one-character string", StringUtil.revert("A"), is("A"));
        assertThat("revert for string", StringUtil.revert("abc d"), is("d cba"));
    }

    @Test
    public void shiftCharactersAndCapitalizeVowels() {
        assertThat("Wrong result for string", StringUtil.shiftCharactersAndCapitalizeVowels("mama"), is("nbnb"));
        assertThat("Wrong result for string with numbers", StringUtil.shiftCharactersAndCapitalizeVowels("mama 45"), is("nbnb 45"));
    }
}
