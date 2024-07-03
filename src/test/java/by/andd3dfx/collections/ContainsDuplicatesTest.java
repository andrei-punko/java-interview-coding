package by.andd3dfx.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class ContainsDuplicatesTest {

    private ContainsDuplicates solver;

    @Before
    public void setUp() throws Exception {
        solver = new ContainsDuplicates();
    }

    @Test
    public void usingSet() {
        checkAssertions(solver::usingSet);
    }

    @Test
    public void usingSortWithEarlyReturn() {
        checkAssertions(solver::usingSortWithEarlyReturn);
    }

    private void checkAssertions(Function<int[], Boolean> function) {
        assertThat(function.apply(new int[]{2, 1, 3, 1})).isTrue();
        assertThat(function.apply(new int[]{2, 1, 3, 56, 4})).isFalse();
        assertThat(function.apply(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2})).isTrue();
    }
}
