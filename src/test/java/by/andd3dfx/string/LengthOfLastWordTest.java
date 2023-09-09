package by.andd3dfx.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LengthOfLastWordTest {

    private LengthOfLastWord lengthOfLastWord;

    @Before
    public void setUp() throws Exception {
        lengthOfLastWord = new LengthOfLastWord();
    }

    @Test
    public void determine() {
        assertThat(lengthOfLastWord.determine("a")).isEqualTo(1);
        assertThat(lengthOfLastWord.determine("day")).isEqualTo(3);
        assertThat(lengthOfLastWord.determine("Hello World")).isEqualTo(5);
        assertThat(lengthOfLastWord.determine("   fly me   to   the moon  ")).isEqualTo(4);
        assertThat(lengthOfLastWord.determine("luffy is still joyboy")).isEqualTo(6);
    }

    @Test
    public void determineWithoutTrim() {
        assertThat(lengthOfLastWord.determineWithoutTrim("a")).isEqualTo(1);
        assertThat(lengthOfLastWord.determineWithoutTrim("day")).isEqualTo(3);
        assertThat(lengthOfLastWord.determineWithoutTrim("Hello World")).isEqualTo(5);
        assertThat(lengthOfLastWord.determineWithoutTrim("   fly me   to   the moon  ")).isEqualTo(4);
        assertThat(lengthOfLastWord.determineWithoutTrim("luffy is still joyboy")).isEqualTo(6);
    }

    @Test
    public void determineUsingRegex() {
        assertThat(lengthOfLastWord.determineUsingRegex("a")).isEqualTo(1);
        assertThat(lengthOfLastWord.determineUsingRegex("day")).isEqualTo(3);
        assertThat(lengthOfLastWord.determineUsingRegex("Hello World")).isEqualTo(5);
        assertThat(lengthOfLastWord.determineUsingRegex("   fly me   to   the moon  ")).isEqualTo(4);
        assertThat(lengthOfLastWord.determineUsingRegex("luffy is still joyboy")).isEqualTo(6);
    }
}