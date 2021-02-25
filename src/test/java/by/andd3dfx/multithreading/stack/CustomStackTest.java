package by.andd3dfx.multithreading.stack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

public class CustomStackTest {

    private CustomStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new CustomStack<>();
    }

    @Test
    public void testStack() {
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertThat(stack.pop(), is(4));
        stack.push(5);
        stack.push(6);
        assertThat(stack.peek(), is(6));
        assertThat(stack.peek(), is(6));
        assertThat(stack.pop(), is(6));
        stack.push(7);
        stack.push(8);
        assertThat(stack.pop(), is(8));
        assertThat(stack.pop(), is(7));
        assertThat(stack.pop(), is(5));
        assertThat(stack.pop(), is(3));
        assertThat(stack.isEmpty(), is(false));
        assertThat(stack.pop(), is(2));
        assertThat(stack.isEmpty(), is(true));
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopForEmptyStack() {
        stack.push(2);
        stack.pop();
        stack.pop();
    }

    @Test
    public void testMultiThreadedStackUsage() {
        Thread thread1 = new Thread(new CustomWork(0, 5));
        Thread thread2 = new Thread(new CustomWork(10, 15));

        thread1.start();
        thread2.start();

        sleep(100);
    }

    private class CustomWork implements Runnable {

        private final int left;
        private final int right;

        public CustomWork(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public void run() {
            for (int i = left; i < right; i++) {
                stack.push(i);
                System.out.println(stack.pop());

                sleep(10);
            }
        }
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
