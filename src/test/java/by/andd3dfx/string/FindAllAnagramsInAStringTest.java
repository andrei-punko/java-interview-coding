package by.andd3dfx.string;

import org.junit.Test;

import java.util.List;

import static by.andd3dfx.string.FindAllAnagramsInAString.findAnagrams;
import static org.assertj.core.api.Assertions.assertThat;

public class FindAllAnagramsInAStringTest {

    @Test
    public void testFindAnagrams() {
        assertThat(findAnagrams("cbaebabacd", "abc")).isEqualTo(List.of(0, 6));
        assertThat(findAnagrams("abab", "ab")).isEqualTo(List.of(0, 1, 2));
        assertThat(findAnagrams("abcabc", "cz")).isEqualTo(List.of());
    }
}
