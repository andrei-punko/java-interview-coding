package by.andd3dfx.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FirstUniqueCharacterInStringTest {

    @Test
    public void firstUniqChar() {
        assertThat(FirstUniqueCharacterInString.firstUniqChar("leetcode"))
            .isEqualTo(0);
        assertThat(FirstUniqueCharacterInString.firstUniqChar("loveleetcode"))
            .isEqualTo(2);
        assertThat(FirstUniqueCharacterInString.firstUniqChar("aabb"))
            .isEqualTo(-1);
    }
}
