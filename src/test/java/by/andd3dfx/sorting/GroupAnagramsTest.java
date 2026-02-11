package by.andd3dfx.sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupAnagramsTest {

    private GroupAnagrams groupAnagrams;

    @Before
    public void setup() {
        groupAnagrams = new GroupAnagrams();
    }

    @Test
    public void apply() {
        var result = groupAnagrams.apply(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        assertThat(result).isEqualTo(List.of(
            List.of("ate", "eat", "tea"),
            List.of("nat", "tan"),
            List.of("bat")
        ));
    }
}
