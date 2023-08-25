package by.andd3dfx.collections.custom;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CustomStackTest {

    private CustomStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new CustomStack<>();
    }

    @Test
    public void pushPop() {
        stack.push(1);
        stack.push(3);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    public void pushPopWhenNoElements() {
        stack.push(1);
        stack.push(3);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(1);
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    public void popWhenNoElements() {
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    public void peekWhenNoElements() {
        assertThrows(NoSuchElementException.class, () -> stack.peek());
    }

    @Test
    public void pushPopPeek() {
        stack.push(1);
        stack.push(3);
        assertThat(stack.peek()).isEqualTo(3);
        assertThat(stack.peek()).isEqualTo(3);
        stack.push(2);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.peek()).isEqualTo(1);
        stack.push(4);
        assertThat(stack.peek()).isEqualTo(4);
        assertThat(stack.peek()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    public void isEmptyNSize() {
        assertTrue(stack.isEmpty());
        assertThat(stack.size()).isEqualTo(0);
        stack.push(1);
        assertThat(stack.size()).isEqualTo(1);
        assertFalse(stack.isEmpty());
        stack.push(3);
        assertFalse(stack.isEmpty());
        assertThat(stack.size()).isEqualTo(2);
        stack.pop();
        assertFalse(stack.isEmpty());
        assertThat(stack.size()).isEqualTo(1);
        stack.peek();
        assertThat(stack.size()).isEqualTo(1);
        stack.pop();
        assertTrue(stack.isEmpty());
        assertThat(stack.size()).isEqualTo(0);
    }
}