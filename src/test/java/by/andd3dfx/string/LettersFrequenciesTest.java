package by.andd3dfx.string;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import by.andd3dfx.string.LettersFrequencies;
import org.junit.Test;

public class LettersFrequenciesTest {

    @Test
    public void build() {
        assertThat(LettersFrequencies.build(""), is(""));
        assertThat(LettersFrequencies.build("a"), is("a1"));
        assertThat(LettersFrequencies.build("aaa"), is("a3"));
        assertThat(LettersFrequencies.build("aaabbc"), is("a3b2c1"));
    }
}
