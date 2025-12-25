package by.andd3dfx.sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SortAnagramsTest {

    private SortAnagrams sortAnagrams;

    @Before
    public void setup() {
        sortAnagrams = new SortAnagrams();
    }

    @Test
    public void apply() {
        var result = sortAnagrams.apply(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        assertThat(result).isEqualTo(List.of(
            List.of("ate", "eat", "tea"),
            List.of("nat", "tan"),
            List.of("bat")
        ));
    }
}
