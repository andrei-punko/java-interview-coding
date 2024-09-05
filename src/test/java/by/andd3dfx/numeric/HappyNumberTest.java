package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.HappyNumber.isHappyUsing2Pointers;
import static by.andd3dfx.numeric.HappyNumber.isHappyUsingMemory;
import static org.assertj.core.api.Assertions.assertThat;

public class HappyNumberTest {

    @Test
    public void testIsHappyUsingMemory() {
        assertThat(isHappyUsingMemory(1)).isTrue();
        assertThat(isHappyUsingMemory(2)).isFalse();
        assertThat(isHappyUsingMemory(19)).isTrue();
        assertThat(isHappyUsingMemory(25)).isFalse();
    }

    @Test
    public void testIsHappyUsing2Pointers() {
        assertThat(isHappyUsing2Pointers(1)).isTrue();
        assertThat(isHappyUsing2Pointers(2)).isFalse();
        assertThat(isHappyUsing2Pointers(19)).isTrue();
        assertThat(isHappyUsing2Pointers(25)).isFalse();
    }
}
