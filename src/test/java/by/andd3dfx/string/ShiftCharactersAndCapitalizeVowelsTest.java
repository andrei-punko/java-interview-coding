package by.andd3dfx.string;

import org.junit.Test;

import static by.andd3dfx.string.ShiftCharactersAndCapitalizeVowels.apply;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShiftCharactersAndCapitalizeVowelsTest {

    @Test
    public void capitalizingNotNeeded() {
        assertThat(apply("mama 45"), is("nbnb 45"));
    }

    @Test
    public void capitalizingRequired() {
        assertThat(apply("tower"), is("Upxfs"));
    }
}
