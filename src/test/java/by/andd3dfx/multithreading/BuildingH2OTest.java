package by.andd3dfx.multithreading;

import lombok.SneakyThrows;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BuildingH2OTest {

    private final int MOLECULES_COUNT = 5;

    @Test
    public void checkPrintingOrder() throws InterruptedException {
        var buildingH2O = new BuildingH2O();

        var result = run(buildingH2O);

        assertFalse("String result should not be empty", result.isBlank());
        assertThat(result.length() % 3).isEqualTo(0);

        for (int i = 0; i < result.length() / 3; i++) {
            var molecule = result.substring(3 * i, 3 * i + 3);
            System.out.println(molecule);
            assertTrue(molecule.equals("OHH") || molecule.equals("HOH") || molecule.equals("HHO"));
        }
    }

    private String run(BuildingH2O buildingH2O) throws InterruptedException {
        var sb = new StringBuilder();

        for (int i = 0; i < MOLECULES_COUNT; i++) {
            new Thread(
                    () -> oxygen(buildingH2O, () -> sb.append("O"))
            ).start();
        }
        for (int i = 0; i < 2 * MOLECULES_COUNT; i++) {
            new Thread(
                    () -> hydrogen(buildingH2O, () -> sb.append("H"))
            ).start();
        }

        Thread.sleep(200);

        return sb.toString();
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
