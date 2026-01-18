package by.andd3dfx.numeric;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MissingNumberTest {

    private MissingNumber missingNumber;

    @Before
    public void setUp() throws Exception {
        missingNumber = new MissingNumber();
    }

    @Test
    public void find_On_memory() {
        assertThat(missingNumber.find_On_memory(new int[]{3, 0, 1})).isEqualTo(2);
        assertThat(missingNumber.find_On_memory(new int[]{0, 1})).isEqualTo(2);
        assertThat(missingNumber.find_On_memory(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})).isEqualTo(8);
    }

    @Test
    public void find_O1_memory() {
        assertThat(missingNumber.find_O1_memory(new int[]{3, 0, 1})).isEqualTo(2);
        assertThat(missingNumber.find_O1_memory(new int[]{0, 1})).isEqualTo(2);
        assertThat(missingNumber.find_O1_memory(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})).isEqualTo(8);
    }
}
