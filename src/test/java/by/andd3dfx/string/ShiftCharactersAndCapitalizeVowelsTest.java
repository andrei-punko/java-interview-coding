package by.andd3dfx.string;

import org.junit.Test;

import static by.andd3dfx.string.ShiftCharactersAndCapitalizeVowels.apply;
import static org.assertj.core.api.Assertions.assertThat;

public class ShiftCharactersAndCapitalizeVowelsTest {

    @Test
    public void capitalizingNotNeeded() {
        assertThat(apply("mama 45")).isEqualTo("nbnb 45");
    }

    @Test
    public void capitalizingRequired() {
        assertThat(apply("tower")).isEqualTo("Upxfs");
    }
}
