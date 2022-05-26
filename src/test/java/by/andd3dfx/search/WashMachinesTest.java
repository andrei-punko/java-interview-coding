package by.andd3dfx.search;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WashMachinesTest {

    @Test
    public void findNoClients() {
        assertThat(WashMachines.find(3, new int[]{})).isEqualTo(0);
    }

    @Test
    public void findManyMachines() {
        assertThat(WashMachines.find(10, new int[]{3, 5, 4})).isEqualTo(5);
    }

    @Test
    public void findOneMachine() {
        assertThat(WashMachines.find(1, new int[]{3, 5, 4})).isEqualTo(12);
    }

    @Test
    public void find() {
        assertThat(WashMachines.find(2, new int[]{3, 5, 4})).isEqualTo(7);
        assertThat(WashMachines.find(3, new int[]{2, 5, 1, 6, 1, 3, 2})).isEqualTo(7);
    }
}
