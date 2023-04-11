package by.andd3dfx.dynamic;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HouseRobberyTest {

    @Test
    public void find() {
        assertThat(HouseRobbery.find(new int[]{5})).isEqualTo(5);
        assertThat(HouseRobbery.find(new int[]{3, 4})).isEqualTo(4);
        assertThat(HouseRobbery.find(new int[]{1, 2, 3, 1})).isEqualTo(4);
        assertThat(HouseRobbery.find(new int[]{2, 7, 9, 3, 1})).isEqualTo(12);
    }
}
