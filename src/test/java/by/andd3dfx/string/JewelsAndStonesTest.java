package by.andd3dfx.string;

import static by.andd3dfx.string.JewelsAndStones.numJewelsInStones;
import static by.andd3dfx.string.JewelsAndStones.numJewelsInStones2;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class JewelsAndStonesTest {

    @Test
    public void testNumJewelsInStones() {
        assertThat(numJewelsInStones("aA", "aAAbbbb")).isEqualTo(3);
        assertThat(numJewelsInStones("z", "ZZ")).isEqualTo(0);
    }

    @Test
    public void testNumJewelsInStones2() {
        assertThat(numJewelsInStones2("aA", "aAAbbbb")).isEqualTo(3);
        assertThat(numJewelsInStones2("z", "ZZ")).isEqualTo(0);
    }
}
