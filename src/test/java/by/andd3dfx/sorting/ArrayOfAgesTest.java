package by.andd3dfx.sorting;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayOfAgesTest {

    @Test
    public void process() {
        int[] ages = new int[]{5, 7, 8, 57, 56, 42, 7, 90, 7, 5, 57};
        Map<Integer, Long> expectedResult = new HashMap() {{
            put(5, 2L);
            put(7, 3L);
            put(8, 1L);
            put(42, 1L);
            put(56, 1L);
            put(57, 2L);
            put(90, 1L);
        }};

        Map<Integer, Long> result = ArrayOfAges.process(ages);

        System.out.println(result);
        assertThat(result).isEqualTo(expectedResult);
    }
}
