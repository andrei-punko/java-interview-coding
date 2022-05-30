package by.andd3dfx.search;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstMissingPositiveTest {

    @Test
    public void find() {
        assertThat(FirstMissingPositive.find(new int[]{-1, 7, -3, 2, 1, 4, -5, 3, 6})).isEqualTo(5);
        assertThat(FirstMissingPositive.find(new int[]{1, 2, 0})).isEqualTo(3);
    }

    @Test
    public void findForSolidRowOfNumbersSoBorderShouldBeFound() {
        assertThat(FirstMissingPositive.find(new int[]{-1, -3, 2, 1, 4, -5, 3})).isEqualTo(5);
    }

    @Test
    public void findForOnlyPositiveElements() {
        assertThat(FirstMissingPositive.find(new int[]{1, 2, 3, 5, 6, 7, 9})).isEqualTo(4);
    }

    @Test
    public void findForOnlyNegativeElements() {
        assertThat(FirstMissingPositive.find(new int[]{-1, -3, -2, -5})).isEqualTo(1);
    }

    @Test
    public void findForOneElement() {
        assertThat(FirstMissingPositive.find(new int[]{1})).isEqualTo(2);
    }

    @Test
    public void findForEmptyArray() {
        assertThat(FirstMissingPositive.find(new int[]{})).isEqualTo(1);
    }
}
