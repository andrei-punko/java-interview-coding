package by.andd3dfx.common;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveElementTest {

    @Test
    public void removeElement0() {
        var numbers = new int[]{1, 3, 5, 7, 9};
        var expected = new int[]{1, 3, 5, 7, 9};

        var result = RemoveElement.removeElement(numbers, 10);

        checkExpectation(numbers, result, 5, expected);
    }

    @Test
    public void removeElement1() {
        var numbers = new int[]{3, 2, 2, 3};
        var expected = new int[]{2, 2};

        var result = RemoveElement.removeElement(numbers, 3);

        checkExpectation(numbers, result, 2, expected);
    }

    @Test
    public void removeElement2() {
        var numbers = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        var expected = new int[]{0, 1, 4, 0, 3};

        var result = RemoveElement.removeElement(numbers, 2);

        checkExpectation(numbers, result, 5, expected);
    }

    private static void checkExpectation(int[] numbers, int result, int expectedResult, int[] expectedNumbers) {
        System.out.println(Arrays.toString(numbers));

        assertThat(result).isEqualTo(expectedResult);
        assertThat(Arrays.copyOfRange(numbers, 0, result))
            .containsExactlyInAnyOrder(expectedNumbers);
    }
}
