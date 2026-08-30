package by.andd3dfx.string;

import org.junit.Test;

import java.util.Set;

import static by.andd3dfx.string.StringComparison.jaroWinklerSimilarity;
import static by.andd3dfx.string.StringComparison.levensteinSimilarity;
import static by.andd3dfx.string.StringComparison.serencen;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.byLessThan;

public class StringComparisonTest {

    @Test
    public void testLevensteinSimilarity() {
        assertSimilarity(levensteinSimilarity("hippo", "zzzzzzzz"), 0.0);
        assertSimilarity(levensteinSimilarity("hello", "hallo"), 0.8);

        assertSimilarity(levensteinSimilarity("Кирпичников", "Кирпичников"), 1.000);
        assertSimilarity(levensteinSimilarity("Кирпичников", "Кирпичникова"), 0.917);
        assertSimilarity(levensteinSimilarity("Кирпичников", "Кирпинчиков"), 0.818);
        assertSimilarity(levensteinSimilarity("Кирпичников", "Икрпичников"), 0.818);
    }

    @Test
    public void testJaroWinklerSimilarity() {
        assertSimilarity(jaroWinklerSimilarity("hippo", "zzzzzzzz"), 0.0);
        assertSimilarity(jaroWinklerSimilarity("hello", "hallo"), 0.880);

        assertSimilarity(jaroWinklerSimilarity("Кирпичников", "Кирпичников"), 1.000);
        assertSimilarity(jaroWinklerSimilarity("Кирпичников", "Кирпичникова"), 0.983);
        assertSimilarity(jaroWinklerSimilarity("Кирпичников", "Кирпинчиков"), 0.982);
        assertSimilarity(jaroWinklerSimilarity("Кирпичников", "Икрпичников"), 0.767);
    }

    private static void assertSimilarity(double actual, double expected) {
        assertThat(actual).isCloseTo(expected, byLessThan(1e-3));
    }

    @Test
    public void testSerencenForStrings() {
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
    public void testSerencenForSets() {
        assertThat(serencen(Set.of(1, 2, 3), Set.of())).isEqualTo(0.0);
        assertThat(serencen(Set.of(1, 2, 3), Set.of(1, 2, 3))).isEqualTo(1.0);
        assertThat(serencen(Set.of(1, 2, 3), Set.of(3, 2, 1))).isEqualTo(1.0);
        assertThat(serencen(Set.of(1, 2, 3, 10), Set.of(1, 3, 2)))
            .isCloseTo(0.8571, byLessThan(1e-4));
    }
}
