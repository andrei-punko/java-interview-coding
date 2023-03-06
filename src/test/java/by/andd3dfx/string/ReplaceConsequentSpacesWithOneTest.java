package by.andd3dfx.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReplaceConsequentSpacesWithOneTest {

    @Test
    public void applyWhenNoSpaces() {
        assertThat(ReplaceConsequentSpacesWithOne.apply("JustString".toCharArray()))
                .isEqualTo("JustString".toCharArray());
    }

    @Test
    public void applyWhenChangesNotNeeded() {
        assertThat(ReplaceConsequentSpacesWithOne.apply("one space is enough".toCharArray()))
                .isEqualTo("one space is enough".toCharArray());
    }

    @Test
    public void apply() {
        assertThat(ReplaceConsequentSpacesWithOne.apply("  one two  three   ".toCharArray()))
                .isEqualTo(" one two three ".toCharArray());
    }
}
