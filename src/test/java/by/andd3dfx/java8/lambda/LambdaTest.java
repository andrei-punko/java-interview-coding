package by.andd3dfx.java8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LambdaTest {

    @Test
    public void usualApproach() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        new Lambda().usualApproach(names);

        checkSorting(names);
    }

    @Test
    public void lamda1() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        new Lambda().lamda1(names);

        checkSorting(names);
    }

    @Test
    public void lamda2() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        new Lambda().lamda2(names);

        checkSorting(names);
    }

    @Test
    public void lamda3() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        new Lambda().lamda3(names);

        checkSorting(names);
    }

    private void checkSorting(List<String> names) {
        assertThat("Size should be unchanged", names.size(), is(4));

        String[] sortedArray = {"anna", "mike", "peter", "xenia"};
        for (int i = 0; i < sortedArray.length; i++) {
            assertThat("Items should be equal", names.get(i), is(sortedArray[i]));
        }
    }
}
