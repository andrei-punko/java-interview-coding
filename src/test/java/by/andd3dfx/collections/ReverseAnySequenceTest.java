package by.andd3dfx.collections;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class ReverseAnySequenceTest {

    @Test
    public void reverseUsingStack() {
        List<Integer> list = asList(1, 4, 8, 9, 2, 7);

        List<Integer> result = ReverseAnySequence.reverseUsingStack(list);

        Collections.reverse(list);
        assertThat(result).isEqualTo(list);
    }

    @Test
    public void reverseUsingRecursion() {
        List<Integer> list = asList(1, 4, 8, 9, 2, 7);

        List<Integer> result = ReverseAnySequence.reverseUsingRecursion(list);

        Collections.reverse(list);
        assertThat(result).isEqualTo(list);
    }

    @Test
    public void reverseUsingLoop() {
        List<Integer> list = asList(1, 4, 8, 9, 2, 7);

        List<Integer> result = ReverseAnySequence.reverseUsingLoop(list);

        Collections.reverse(list);
        assertThat(result).isEqualTo(list);
    }
}
