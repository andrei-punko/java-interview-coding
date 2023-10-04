package by.andd3dfx.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveDuplicatesFromSortedArray2Test {

    private RemoveDuplicatesFromSortedArray2 removeDuplicatesFromSortedArray;

    @Before
    public void setUp() throws Exception {
        removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray2();
    }

    @Test
    public void removeDuplicates() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int[] expected = new int[]{1, 1, 2, 2, 3};

        makeCallAndCheckAssertions(nums, expected);
    }

    @Test
    public void removeDuplicates2() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] expected = new int[]{0, 0, 1, 1, 2, 3, 3};

        makeCallAndCheckAssertions(nums, expected);
    }

    @Test
    public void removeDuplicatesWhenNoDuplicates() {
        int[] nums = new int[]{0, 1, 2, 4, 5};
        int[] expected = nums.clone();

        makeCallAndCheckAssertions(nums, expected);
    }

    private void makeCallAndCheckAssertions(int[] nums, int[] expected) {
        var result = removeDuplicatesFromSortedArray.removeDuplicates(nums);

        assertThat(result).isEqualTo(expected.length);
        assertThat(Arrays.copyOfRange(nums, 0, expected.length)).isEqualTo(expected);
    }
}
