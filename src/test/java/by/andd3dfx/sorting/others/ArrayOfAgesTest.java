package by.andd3dfx.sorting.others;

import org.junit.Test;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayOfAgesTest {

    @Test
    public void process() {
        int[] ages = new int[]{7, 5, 6, 7, 9, 12, 45, 41, 90, 41, 91, 41};
        LinkedHashMap<Integer, Long> expectedResult = new LinkedHashMap<>();
        expectedResult.put(5, 1L);
        expectedResult.put(6, 1L);
        expectedResult.put(7, 2L);
        expectedResult.put(9, 1L);
        expectedResult.put(12, 1L);
        expectedResult.put(41, 3L);
        expectedResult.put(45, 1L);
        expectedResult.put(90, 1L);
        expectedResult.put(91, 1L);

        LinkedHashMap<Integer, Long> result = ArrayOfAges.process(ages);

        assertThat(result).isEqualTo(expectedResult);
    }
}
