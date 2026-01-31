package by.andd3dfx.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ConsecutiveCharactersTest {

    @Test
    public void maxPower() {
        assertThat(ConsecutiveCharacters.maxPower("abcdef")).isEqualTo(1);
        assertThat(ConsecutiveCharacters.maxPower("ffffff")).isEqualTo(6);
        assertThat(ConsecutiveCharacters.maxPower("ggwpbbbbaac")).isEqualTo(4);

        assertThat(ConsecutiveCharacters.maxPower("leetcode")).isEqualTo(2);
        assertThat(ConsecutiveCharacters.maxPower("abbcccddddeeeeedcba")).isEqualTo(5);
    }
}
