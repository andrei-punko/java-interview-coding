package by.andd3dfx.collections;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomStackWithMinSupportTest {

    private CustomStackWithMinSupport stack;

    @Before
    public void setUp() {
        stack = new CustomStackWithMinSupport();
    }

    @Test
    public void test() {
        stack.push(2);
        stack.push(1);
        stack.push(5);
        stack.push(3);
        assertThat(stack.getMin()).isEqualTo(1);
        assertThat(stack.getMin()).isEqualTo(1);    // To be sure that getMin() doesn't remove elements

        assertThat(stack.pop()).isEqualTo(3);
        stack.push(-1);
        assertThat(stack.getMin()).isEqualTo(-1);

        assertThat(stack.pop()).isEqualTo(-1);
        assertThat(stack.getMin()).isEqualTo(1);
    }
}
