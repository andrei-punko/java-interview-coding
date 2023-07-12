package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.FindNumberWhichAppearsOnce.find;
import static by.andd3dfx.numeric.FindNumberWhichAppearsOnce.findSubOptimal;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FindNumberWhichAppearsOnceTest {

    @Test
    public void testFindSubOptimal() {
        assertThat(findSubOptimal(new int[]{2})).isEqualTo(2);
        assertThat(findSubOptimal(new int[]{1, 7, 3, 1, 3})).isEqualTo(7);
        assertThat(findSubOptimal(new int[]{1, 2, 3, 3, 2, 5, 1})).isEqualTo(5);
    }

    @Test
    public void testFind() {
        assertThat(find(new int[]{2})).isEqualTo(2);
        assertThat(find(new int[]{1, 7, 3, 1, 3})).isEqualTo(7);
        assertThat(find(new int[]{1, 2, 3, 3, 2, 5, 1})).isEqualTo(5);
    }
}
