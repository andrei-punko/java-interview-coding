package by.andd3dfx.string;

import org.junit.Test;

import java.util.Set;

import static by.andd3dfx.string.StringComparison.serencen;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.byLessThan;

public class StringComparisonTest {

    @Test
    public void serencenForStrings() {
        assertThat(serencen("кот", "каток")).isEqualTo(0.0);
        assertThat(serencen("Andrei", "Andrei")).isEqualTo(1.0);
        assertThat(serencen("Andrei", "Andrew")).isEqualTo(0.8);
        assertThat(serencen("кошка", "кошак")).isEqualTo(0.5);
        assertThat(serencen("кошка", "носок")).isEqualTo(0.0);
        assertThat(serencen("Василевский", "Василевские")).isEqualTo(0.9);
        assertThat(serencen("алкогольдегидрогеназа", "алкоголь гидропоника генезис"))
            .isCloseTo(0.5778, byLessThan(0.0001));
    }

    @Test
    public void serencenForSets() {
        assertThat(serencen(Set.of(1, 2, 3), Set.of())).isEqualTo(0.0);
        assertThat(serencen(Set.of(1, 2, 3), Set.of(1, 2, 3))).isEqualTo(1.0);
        assertThat(serencen(Set.of(1, 2, 3), Set.of(3, 2, 1))).isEqualTo(1.0);
        assertThat(serencen(Set.of(1, 2, 3, 10), Set.of(1, 3, 2)))
            .isCloseTo(0.8571, byLessThan(1e-4));
    }
}
