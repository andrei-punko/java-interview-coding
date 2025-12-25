package by.andd3dfx.multithreading;

import lombok.SneakyThrows;
import org.awaitility.Durations;
import org.junit.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertTrue;

public class BuildingH2OTest {

    private final int MOLECULES_COUNT = 5;
    private final Set<String> POSSIBLE_MOLECULES = Set.of("OHH", "HOH", "HHO");

    @Test
    public void checkPrintingOrder() {
        var buildingH2O = new BuildingH2O();

        // Use StringBuffer instead of StringBuilder for thread-safety
        var sb = new StringBuffer();

        for (int i1 = 0; i1 < MOLECULES_COUNT; i1++) {
            new Thread(
                () -> oxygen(buildingH2O, () -> sb.append("O"))
            ).start();
        }
        for (int i1 = 0; i1 < 2 * MOLECULES_COUNT; i1++) {
            new Thread(
                () -> hydrogen(buildingH2O, () -> sb.append("H"))
            ).start();
        }

        await()
            .atMost(Durations.ONE_MINUTE)
            .pollInterval(200, TimeUnit.MILLISECONDS)
            .until(() -> sb.length() == 3 * MOLECULES_COUNT);

        var result = sb.toString();
        assertThat(result.length()).isEqualTo(3 * MOLECULES_COUNT);

        for (int i = 0; i < result.length() / 3; i++) {
            var molecule = result.substring(3 * i, 3 * (i + 1));
            System.out.println("Created molecule: " + molecule);
            assertTrue(POSSIBLE_MOLECULES.contains(molecule));
        }
    }

    @SneakyThrows
    private void hydrogen(BuildingH2O buildingH2O, Runnable runnable) {
        buildingH2O.hydrogen(runnable);
    }

    @SneakyThrows
    private void oxygen(BuildingH2O buildingH2O, Runnable runnable) {
        buildingH2O.oxygen(runnable);
    }
}
