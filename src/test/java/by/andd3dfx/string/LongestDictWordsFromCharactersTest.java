package by.andd3dfx.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestDictWordsFromCharactersTest {

    @Test
    public void find() {
        assertThat(LongestDictWordsFromCharacters.find(
            new char[]{'e', 'o', 't', 's'},
            new String[]{"otse", "tse", "eo", "stoe"}
        )).containsExactlyInAnyOrder("otse", "stoe");

        assertThat(LongestDictWordsFromCharacters.find(
            new char[]{'a', 's', 'd', 'd'},
            new String[]{"add", "addd", "ad", "aeds"}
        )).containsExactlyInAnyOrder("add");
    }

    @Test
    public void find_forEmptyCharacters() {
        assertThat(LongestDictWordsFromCharacters.find(
            new char[]{},
            new String[]{"asd", "dasd", "sadd", "adsdt", "asdd"}
        )).isEmpty();
    }

    @Test
    public void find_forEmptyWords() {
        assertThat(LongestDictWordsFromCharacters.find(
            new char[]{'a', 's', 'd', 'd'},
            new String[]{}
        )).isEmpty();
    }
}
