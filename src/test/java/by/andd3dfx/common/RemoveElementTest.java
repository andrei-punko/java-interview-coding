package by.andd3dfx.common;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveElementTest {

    @Test
    public void removeElement1() {
        var numbers = new int[]{3, 2, 2, 3};
        var expected = new int[]{2, 2};

        var result = RemoveElement.removeElement(numbers, 3);

        System.out.println(Arrays.toString(numbers));
        assertThat(result).isEqualTo(2);
        assertThat(Arrays.copyOfRange(numbers, 0, result))
                .containsExactlyInAnyOrder(expected);
    }

    @Test
    public void removeElement2() {
        var numbers = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        var expected = new int[]{0, 1, 4, 0, 3};

        var result = RemoveElement.removeElement(numbers, 2);

        System.out.println(Arrays.toString(numbers));
        assertThat(result).isEqualTo(5);
        assertThat(Arrays.copyOfRange(numbers, 0, result))
                .containsExactlyInAnyOrder(expected);
    }
}
