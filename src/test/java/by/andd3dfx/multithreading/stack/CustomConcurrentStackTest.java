package by.andd3dfx.multithreading.stack;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomConcurrentStackTest {

    private CustomConcurrentStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new CustomConcurrentStack<>();
    }

    @Test
    public void testStack() {
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertThat(stack.pop()).isEqualTo(4);
        stack.push(5);
        stack.push(6);
        assertThat(stack.peek()).isEqualTo(6);
        assertThat(stack.peek()).isEqualTo(6);
        assertThat(stack.pop()).isEqualTo(6);
        stack.push(7);
        stack.push(8);
        assertThat(stack.pop()).isEqualTo(8);
        assertThat(stack.pop()).isEqualTo(7);
        assertThat(stack.pop()).isEqualTo(5);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.isEmpty()).isEqualTo(false);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.isEmpty()).isEqualTo(true);
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
