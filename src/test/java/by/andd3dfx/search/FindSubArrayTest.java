package by.andd3dfx.search;

import lombok.AllArgsConstructor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FindSubArrayTest {

    @Test
    public void find() {
        TestCase[] testCases = {
                new TestCase(new Integer[]{-1, 2, 2, 5, 7}, new Integer[]{2, 5, 8, 8, 8}, new Integer[]{-1, 7}),
                new TestCase(new Integer[]{-1, -1, 0, 1, 4, 4}, new Integer[]{-1, 0}, new Integer[]{1, 4}),
                new TestCase(new Integer[]{-1, -1, 0}, new Integer[]{-1, 0, 0}, new Integer[]{}),
                new TestCase(new Integer[]{}, new Integer[]{-1, 0}, new Integer[]{})
        };

        for (TestCase testCase : testCases) {
            assertThat(FindSubArray.find(testCase.a, testCase.b), is(testCase.result));
        }
    }

    @AllArgsConstructor
    public class TestCase {
        Integer[] a;
        Integer[] b;
        Integer[] result;
    }
}
