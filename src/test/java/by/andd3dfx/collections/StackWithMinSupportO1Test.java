package by.andd3dfx.collections;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StackWithMinSupportO1Test {

    private StackWithMinSupportO1 stack;

    @Before
    public void setUp() {
        stack = new StackWithMinSupportO1();
    }

    @Test
    public void pushPop() {
        stack.push(1);
        stack.push(3);
        stack.push(2);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(3);
        stack.push(4);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    public void isEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.push(3);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void getMin() {
        stack.push(2);
        stack.push(1);
        stack.push(5);
        stack.push(3);
        assertThat(stack.getMin()).isEqualTo(1);
        assertThat(stack.getMin()).isEqualTo(1);    // To be sure that getMin() doesn't remove elements

        stack.pop();
        stack.push(-1);
        assertThat(stack.getMin()).isEqualTo(-1);
    }

    @Test
    public void getMinWhen2ElementsEqualToMinValue() {
        stack.push(2);
        stack.push(1);      // First occur of min value
        stack.push(5);
        stack.push(1);      // Second occur of min value
        stack.push(3);
        assertThat(stack.getMin()).isEqualTo(1);
        assertThat(stack.getMin()).isEqualTo(1);    // To be sure that getMin() doesn't remove elements

        stack.pop();
        stack.push(-1);
        assertThat(stack.getMin()).isEqualTo(-1);

        // Check case with 2 elements equal to min value
        stack.pop();
        assertThat(stack.getMin()).isEqualTo(1);
        stack.pop();
        assertThat(stack.getMin()).isEqualTo(1);
    }
}
